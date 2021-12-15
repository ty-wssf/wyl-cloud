<template>
  <div class="app-container">
    <!-- 搜索区域 -->
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="公告标题" prop="noticeTitle">
        <el-input
          v-model="queryParams.noticeTitle"
          placeholder="请输入公告标题"
          clearable
          size="small"
          style="width: 240px"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型" prop="noticeType">
        <el-select v-model="queryParams.noticeType" placeholder="公告类型" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_notice_type"
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
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
        >修改
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="pageList"></right-toolbar>
    </el-row>
    <!-- table区域 -->
    <el-table v-loading="loading" :data="pageListData">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="公告ID" align="center" prop="noticeId" :show-overflow-tooltip="true"/>
      <el-table-column label="公告标题" align="center" prop="noticeTitle" :show-overflow-tooltip="true"/>
      <el-table-column label="公告类型（1通知 2公告）" align="center" prop="noticeType" :show-overflow-tooltip="true"/>
      <el-table-column label="公告内容" align="center" prop="noticeContent" :show-overflow-tooltip="true"/>
      <el-table-column label="公告状态（0正常 1关闭）" align="center" prop="status" :show-overflow-tooltip="true"/>
      <el-table-column label="创建者" align="center" prop="createBy" :show-overflow-tooltip="true"/>
      <el-table-column label="创建时间" align="center" prop="createTime" :show-overflow-tooltip="true"/>
      <el-table-column label="更新者" align="center" prop="updateBy" :show-overflow-tooltip="true"/>
      <el-table-column label="更新时间" align="center" prop="updateTime" :show-overflow-tooltip="true"/>
      <el-table-column label="备注" align="center" prop="remark" :show-overflow-tooltip="true"/>
      <el-table-column label="操作" align="center">
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
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="pageList"
    />

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="公告标题" prop="noticeTitle">
          <el-input v-model="form.noticeTitle" placeholder="请输入公告标题"/>
        </el-form-item>
        <el-form-item label="公告类型（1通知 2公告）" prop="noticeType">
          <el-input v-model="form.noticeType" placeholder="请输入公告类型（1通知 2公告）"/>
        </el-form-item>
        <el-form-item label="公告内容" prop="noticeContent">
          <el-input v-model="form.noticeContent" placeholder="请输入公告内容"/>
        </el-form-item>
        <el-form-item label="公告状态（0正常 1关闭）" prop="status">
          <el-input v-model="form.status" placeholder="请输入公告状态（0正常 1关闭）"/>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注"/>
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
  import {pageList, getInfo, add, edit, remove} from "@/api/system/notice";

  export default {
    name: "notice",
    dicts: ['sys_notice_type'],
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
          pageNum: 1,
          pageSize: 10
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
        this.dateRange = [];
        this.resetForm("queryForm");
        this.handleQuery();
      },
      // 表单重置
      reset() {
        this.form = {
          noticeId: undefined,
          noticeTitle: undefined,
          noticeType: undefined,
          noticeContent: undefined,
          status: undefined,
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
        const noticeId = row.noticeId || this.ids;
        getInfo(configId).then(response => {
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




