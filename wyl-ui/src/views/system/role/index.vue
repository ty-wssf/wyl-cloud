<template>
  <div class="app-container">
    <!-- 搜索区域 -->
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">

    </el-form>

    <!-- table tool区域 -->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
        >新增
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="pageList"></right-toolbar>
    </el-row>
    <!-- table区域 -->
    <el-table v-loading="loading" :data="pageListData">
      <!--<el-table-column type="selection" width="55" align="center"/>-->
      <el-table-column label="角色编号" prop="roleId" width="120"/>
      <el-table-column label="角色名称" prop="roleName" :show-overflow-tooltip="true" width="150"/>
      <el-table-column label="权限字符" prop="roleKey" :show-overflow-tooltip="true" width="150"/>
      <el-table-column label="显示顺序" prop="roleSort" width="100"/>
      <el-table-column label="状态" align="center" width="100">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.status"
            active-value="0"
            inactive-value="1"
            @change="handleStatusChange(scope.row)"
          ></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope" v-if="scope.row.roleId !== 1">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
          >删除
          </el-button>
          <el-dropdown size="mini" @command="(command) => handleCommand(command, scope.row)">
            <span class="el-dropdown-link">
              <i class="el-icon-d-arrow-right el-icon--right"></i>更多
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="handleDataScope" icon="el-icon-circle-check"
              >数据权限
              </el-dropdown-item>
              <el-dropdown-item command="handleAuthUser" icon="el-icon-user"
              >分配用户
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件区域 -->
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="pageList"
    />

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="角色名称" prop="roleName">
              <el-input v-model="form.roleName" placeholder="请输入角色名称"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="角色权限字符串" prop="roleKey">
              <el-input v-model="form.roleKey" placeholder="请输入角色权限字符串"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="显示顺序" prop="roleSort">
              <el-input v-model="form.roleSort" placeholder="请输入显示顺序"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）" prop="dataScope">
              <el-input v-model="form.dataScope"
                        placeholder="请输入数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="菜单树选择项是否关联显示" prop="menuCheckStrictly">
              <el-input v-model="form.menuCheckStrictly" placeholder="请输入菜单树选择项是否关联显示"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="部门树选择项是否关联显示" prop="deptCheckStrictly">
              <el-input v-model="form.deptCheckStrictly" placeholder="请输入部门树选择项是否关联显示"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="角色状态（0正常 1停用）" prop="status">
              <el-input v-model="form.status" placeholder="请输入角色状态（0正常 1停用）"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="删除标志（0代表存在 2代表删除）" prop="delFlag">
              <el-input v-model="form.delFlag" placeholder="请输入删除标志（0代表存在 2代表删除）"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="备注" prop="remark">
              <el-input v-model="form.remark" placeholder="请输入备注"/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {pageList, getInfo, add, edit, remove} from "@/api/system/role";

  export default {
    name: "sysRole",
    data() {
      return {
        // 遮罩层
        loading: true,
        // 选中数组
        ids: [],
        // 非单个禁用
        single: true,
        // 非多个禁用
        multiple: true,
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 参数表格数据
        pageListData: [],
        // 弹出层标题
        title: "",
        // 是否显示弹出层
        open: false,
        // 日期范围
        dateRange: [],
        // 查询参数
        queryParams: {
          pageQuery: {
            pageIndex: 1,
            pageSize: 10
          }
        },
        // 表单参数
        form: {},
        // 表单校验
        rules: {}
      };
    },
    created() {
      this.pageList();
    },
    methods: {
      /** 查询参数列表 */
      pageList() {
        this.loading = true;
        pageList(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
            this.pageListData = response.data;
            this.total = response.totalCount;
            this.loading = false;
          }
        );
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.pageList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 表单重置
      reset() {
        this.form = {
          roleId: undefined,
          roleName: undefined,
          roleKey: undefined,
          roleSort: undefined,
          dataScope: undefined,
          menuCheckStrictly: undefined,
          deptCheckStrictly: undefined,
          status: undefined,
          delFlag: undefined,
          remark: undefined,
          remark: undefined
        };
        this.resetForm("form");
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      /** 新增按钮操作 */
      handleAdd() {
        this.reset();
        this.open = true;
        this.title = "添加参数";
      },
      /** 修改按钮操作 */
      handleUpdate(row) {
        this.reset();
        const roleId = row.roleId || this.ids;
        getInfo(roleId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改参数";
        });
      },
      /** 提交按钮 */
      submitForm: function () {
      },
      /** 删除按钮操作 */
      handleDelete(row) {

      },
      /** 导出按钮操作 */
      handleExport() {

      },
    }
  };
</script>




