<template>
  <div class="app-container">
    <!-- 搜索区域 -->
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="岗位编码" prop="postCode">
        <el-input
          v-model="queryParams.postCode"
          placeholder="请输入岗位编码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="岗位名称" prop="postName">
        <el-input
          v-model="queryParams.postName"
          placeholder="请输入岗位名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="岗位状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
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
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="岗位编号" align="center" prop="postId"/>
      <el-table-column label="岗位编码" align="center" prop="postCode"/>
      <el-table-column label="岗位名称" align="center" prop="postName"/>
      <el-table-column label="岗位排序" align="center" prop="postSort"/>
      <el-table-column label="状态" align="center" prop="status">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
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
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页组件区域 -->
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageQuery.pageNum"
      :limit.sync="queryParams.pageQuery.pageSize"
      @pagination="pageList"
    />

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="岗位名称" prop="postName">
          <el-input v-model="form.postName" placeholder="请输入岗位名称"/>
        </el-form-item>
        <el-form-item label="岗位编码" prop="postCode">
          <el-input v-model="form.postCode" placeholder="请输入编码名称"/>
        </el-form-item>
        <el-form-item label="岗位顺序" prop="postSort">
          <el-input-number v-model="form.postSort" controls-position="right" :min="0"/>
        </el-form-item>
        <el-form-item label="岗位状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in dict.type.sys_normal_disable"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
  import {pageList, getInfo, add, edit, remove} from "@/api/system/post";

  export default {
    name: "post",
    dicts: ['sys_normal_disable'],
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
        rules: {
          postName: [
            {required: true, message: "岗位名称不能为空", trigger: "blur"}
          ],
          postCode: [
            {required: true, message: "岗位编码不能为空", trigger: "blur"}
          ],
          postSort: [
            {required: true, message: "岗位顺序不能为空", trigger: "blur"}
          ]
        }
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
          postSort: 0,
          status: "0",
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
        const postId = row.postId || this.ids;
        getInfo(postId).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "修改参数";
        });
      },
      /** 提交按钮 */
      submitForm: function () {
        this.$refs["form"].validate(valid => {
          if (valid) {
            if (this.form.postId != undefined) {
              edit(this.form.postId, this.form).then(response => {
                this.$modal.msgSuccess("修改成功");
                this.open = false;
                this.pageList();
              });
            } else {
              add(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.pageList();
              });
            }
          }
        });
      },
      /** 删除按钮操作 */
      handleDelete(row) {
        const postId = row.postId || this.ids;
        this.$modal.confirm('是否确认删除岗位编号为"' + postId + '"的数据项？').then(function () {
          return remove(postId);
        }).then(() => {
          this.pageList();
          this.$modal.msgSuccess("删除成功");
        }).catch(() => {
        });
      },
      /** 导出按钮操作 */
      handleExport() {

      },
    }
  };
</script>




