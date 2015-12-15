<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jQuery jTable Setup in java</title>
<!-- jTable Metro styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
<script type="text/javascript">
        $(document).ready(function() {
                $('#StudentTableContainer').jtable({
                        title : 'Students List',
                        actions : {
                                listAction : 'Controller?action=list',
                                createAction:'Controller?action=create',
                                updateAction: 'Controller?action=update',
                                deleteAction: 'Controller?action=delete' 		
                        },
                        fields : {
                                studentId : {
                                        title : 'Student Id',
                                        width : '30%',
                                        key : true,
                                        list : true,
                                        create : true
                                },
                                name : {
                                        title : 'Name',
                                        width : '30%',
                                        edit : false
                                },
                                department : {
                                        title : 'Department',
                                        width : '30%',
                                        edit : true
                                },
                                emailId : {
                                        title : 'Email',
                                        width : '20%',
                                        edit : true
                                }
                        }
                });
                $('#StudentTableContainer').jtable('load');
        });
</script>

</head>
<body>
<div style="text-align: center;">
        <h4>jQuery jTable Setup in java</h4>
        <div id="StudentTableContainer"></div>
</div>
</body>
</html>