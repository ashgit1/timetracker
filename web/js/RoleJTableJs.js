$(document).ready(function() {
        $('#RoleTableContainer').jtable({
                title : 'List of Roles',
                sorting: true,	//Enable sorting
                defaultSorting: 'roleId ASC',	//Set default sorting
                actions : {
                        listAction 	 : 'RoleController?action=list',
                        createAction : 'RoleController?action=create',
                        updateAction : 'RoleController?action=update',
                        deleteAction : 'RoleController?action=delete'
                },
                fields : {
                		roleId : {
                                title : 'Role Id',
                                width : '10%',
                                key : true,
                                list : true,
                                edit : false,
                                create : true
                        },
                        roleName : {
                                title : 'Role Name',
                                width : '20%',
                                edit : true
                        },
                        decription : {
                                title : 'Role Description',
                                width : '40%',
                                edit : true,
                        }
                }
        });
        $('#RoleTableContainer').jtable('load');
});