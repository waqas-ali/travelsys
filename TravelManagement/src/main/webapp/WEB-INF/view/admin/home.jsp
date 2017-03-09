<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <%@include file="../includes/header.jspf" %>
        <title>Travel Management Portal</title>

    </head>
    <body>
        <div id="wrapper">
            <%@include file="../includes/navigation.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Users
                            </h1>
                        </div>
                    </div>

                    <div class="row right">
                        <div class="col-lg-12">
                            <div class="col-md-9">
                            </div>
                        </div>
                    </div>
                    <div class="row">&nbsp;</div>
                    <div class="row">
                        <div class="col-lg-12" >
                            <div class="panel panel-default">
                                <div class="panel-heading"></div>
                                <div class="panel-body">
                                    <div class="dataTable_wrapper" style="overflow:auto">
                                        <table class="table table-striped table-bordered table-hover" id="user-list">
                                            <thead>
                                                <tr>
                                                    <th>Email</th>
                                                    <th>Role</th>
                                                    <th>Account ID</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="../includes/footer.jspf" %>
        
        <script>
            $(document).ready(function () {

                $('#user-list').DataTable(
                        {
                            "responsive": true,
                            "filter": true,
                            "bProcessing": true,
                            "serverSide": false,
                            "bStateSave": true,
                            "aLengthMenu": [[5, 20, 50, 100, 5000], [5, 20, 50, 100, "All"]],
                            "ajax": "${baseURL}/base/getAllUsers.htm",
                            "aoColumns": [
                                {"mData": "email",
                                    "sDefaultContent": "",
                                    "sWidth": "25%"},
                                {"mData": "role",
                                    "sDefaultContent": "",
                                    "sWidth": "25%",
                                    "bSortable": true},
                                {"mData": "accountId",
                                    "sDefaultContent": "",
                                    "sWidth": "25%"}
                            ]
                        }
                );
            });
        </script>

    </body>


</html>
