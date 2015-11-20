$(document).ready(function() {
        $('#ProjectTableContainer').jtable({
                title : 'Projects List',
                paging: true, 	//Enable paging
                pageSize: 10,	//Set page size (default: 10)
                sorting: true,	//Enable sorting
                defaultSorting: 'projectId ASC',	//Set default sorting
                actions : {
                        listAction 	 : 'ProjectController?action=list',
                        createAction : 'ProjectController?action=create',
                        updateAction : 'ProjectController?action=update',
                        deleteAction : 'ProjectController?action=delete'
                },
                fields : {
                        projectId : {
                                title : 'Project Id',
                                width : '10%',
                                key : true,
                                list : true,
                                edit : false,
                                create : true
                        },
                        projectName : {
                                title : 'Name',
                                width : '20%',
                                edit : true
                        },
                        projectActive : {
                                title : 'Active',
                                width : '10%',
                                edit : true,
                                options: { 'A': 'Active', 'N': 'Non-Active' }
                        },
                        projectDescription : {
                                title : 'Description',
                                width : '30%',
                                type: 'textarea',
                                edit : true
                        },
                        projectStartDate : {
                            	title : 'Start Date',
                            	width : '10%',
                            	type: 'date'/*,
                                displayFormat: 'yy-mm-dd'*/
                        },
                        projectEndDate : {
                        		title : 'End Date',
                        		width : '10%',
                        		type: 'date'/*,
                                displayFormat: 'yy-mm-dd'*/
                        },
                        projectManagerUserId : {
                            title : 'PM Id',
                            width : '20%',
                            edit : true
                        }
                }
        });
        $('#ProjectTableContainer').jtable('load');
});