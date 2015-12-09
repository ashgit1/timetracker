$(document).ready(function() {
        $('#UserTableContainer').jtable({
                title : 'List of Users',
                sorting: true,	//Enable sorting
                defaultSorting: 'roleId ASC',	//Set default sorting
                actions : {
                        listAction 	 : 'UserController?action=list',
                        createAction : 'UserController?action=create',
                        updateAction : 'UserController?action=update',
                        deleteAction : 'UserController?action=delete'
                },
                fields : {
                		userId : {
                                title :  'User Id',
                                width :  '10%',
                                key :    true,
                                list :   false,
                                edit :   false,
                                create : true
                        },
                        userName : {
                                title : 'User Name',
                                width : '20%',
                                edit : true
                        },
                        password : {
                                title : 'Password',
                                width : '20%',
                                edit  : false,
                                list :   false
                        },
                        displayName : {
                            	title : 'Display Name',
                            	width : '20%',
                            	edit  : true
                        },
                        projectID : {
                            	title : 'Project Id',
                            	width : '20%',
                            	edit  : true,
                        },
                        roleId : {
                            	title : 'Role Id',
                            	width : '20%',
                            	edit  : true,
                        },
                        projectName : {
                        	title : 'Project Name',
                        	width : '10%',
                        	list  : false,
                        	options : 'UserController?action=getProjectNames'
                       }
                        
                }
                
        });
      //Re-load records when user click 'load records' button.
        $('#LoadRecordsButton').click(function (e) {
            e.preventDefault();
            $('#UserTableContainer').jtable('load', {
            	userName: $('#userName').val(),
            	projectID: $('#projectID').val()
            });
        });
 
        //Load all records when page is first shown
        $('#LoadRecordsButton').click();
}); 