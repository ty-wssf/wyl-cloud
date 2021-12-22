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
            <el-table-column label="角色ID" align="center" prop="roleId" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="角色名称" align="center" prop="roleName" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="角色权限字符串" align="center" prop="roleKey" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="显示顺序" align="center" prop="roleSort" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）" align="center" prop="dataScope"
                             width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="菜单树选择项是否关联显示" align="center" prop="menuCheckStrictly" width="100"
                             :show-overflow-tooltip="true"/>
            <el-table-column label="部门树选择项是否关联显示" align="center" prop="deptCheckStrictly" width="100"
                             :show-overflow-tooltip="true"/>
            <el-table-column label="角色状态（0正常 1停用）" align="center" prop="status" width="100"
                             :show-overflow-tooltip="true"/>
            <el-table-column label="删除标志（0代表存在 2代表删除）" align="center" prop="delFlag" width="100"
                             :show-overflow-tooltip="true"/>
            <el-table-column label="创建者" align="center" prop="createBy" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="创建时间" align="center" prop="createTime" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="更新者" align="center" prop="updateBy" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="更新时间" align="center" prop="updateTime" width="100" :show-overflow-tooltip="true"/>
            <el-table-column label="备注" align="center" prop="remark" width="100" :show-overflow-tooltip="true"/>
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




