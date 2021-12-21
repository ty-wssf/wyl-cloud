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
            <el-table-column label="部门id" align="center" prop="deptId" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="父部门id" align="center" prop="parentId" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="祖级列表" align="center" prop="ancestors" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="部门名称" align="center" prop="deptName" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="显示顺序" align="center" prop="orderNum" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="负责人" align="center" prop="leader" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="联系电话" align="center" prop="phone" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="邮箱" align="center" prop="email" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="部门状态（0正常 1停用）" align="center" prop="status" width="100"
                             :show-overflow-tooltip="true"/>
            <el-table-column label="删除标志（0代表存在 1代表删除）" align="center" prop="delFlag" width="100"
                             :show-overflow-tooltip="true"/>
            <el-table-column label="创建者" align="center" prop="createBy" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="创建时间" align="center" prop="createTime" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="更新者" align="center" prop="updateBy" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="更新时间" align="center" prop="updateTime" width="100" :show-overflow-tooltip="true"/>
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
        <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="父部门id" prop="parentId">
                            <el-input v-model="form.parentId" placeholder="请输入父部门id"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="祖级列表" prop="ancestors">
                            <el-input v-model="form.ancestors" placeholder="请输入祖级列表"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="部门名称" prop="deptName">
                            <el-input v-model="form.deptName" placeholder="请输入部门名称"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="显示顺序" prop="orderNum">
                            <el-input v-model="form.orderNum" placeholder="请输入显示顺序"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="负责人" prop="leader">
                            <el-input v-model="form.leader" placeholder="请输入负责人"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="联系电话" prop="phone">
                            <el-input v-model="form.phone" placeholder="请输入联系电话"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="邮箱" prop="email">
                            <el-input v-model="form.email" placeholder="请输入邮箱"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="部门状态（0正常 1停用）" prop="status">
                            <el-input v-model="form.status" placeholder="请输入部门状态（0正常 1停用）"/>
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="删除标志（0代表存在 1代表删除）" prop="delFlag">
                            <el-input v-model="form.delFlag" placeholder="请输入删除标志（0代表存在 1代表删除）"/>
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
    import {pageList, getInfo, add, edit, remove} from "@/api/system/notice";

    export default {
        name: "Config",
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
                    deptId: undefined,
                    parentId: undefined,
                    ancestors: undefined,
                    deptName: undefined,
                    orderNum: undefined,
                    leader: undefined,
                    phone: undefined,
                    email: undefined,
                    status: undefined,
                    delFlag: undefined,
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
                const deptId = row.deptId || this.ids;
                getInfo(deptId).then(response => {
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




