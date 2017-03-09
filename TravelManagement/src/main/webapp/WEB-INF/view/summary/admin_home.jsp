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
                            <h1 class="page-header">Summary
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
                                        <table class="table table-striped table-bordered table-hover" id="report-list">
                                            <thead>
                                                <tr>
                                                    <th>Account ID</th>
                                                    <th>Tickets</th>
                                                    <th>From</th>
                                                    <th>To</th>
                                                    <th>Price</th>
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
                //alert($.datepicker);
                

                $('#report-list').DataTable(
                        {
                            "responsive": true,
                            "filter": true,
                            "bProcessing": true,
                            "serverSide": false,
                            "bStateSave": true,
                            "aLengthMenu": [[5, 20, 50, 100, 5000], [5, 20, 50, 100, "All"]],
                            "ajax": "${baseURL}/summary/getAllOrders.htm",
                            "aoColumns": [
                                {"mData": "accountId",
                                    "sDefaultContent": "",
                                    "sWidth": "20%",
                                    "bSortable": true},
                                {"mData": "tickets",
                                    "sDefaultContent": "",
                                    "sWidth": "20%"},
                                {"mData": "from",
                                    "sDefaultContent": "",
                                    "sWidth": "20%"},
                                {"mData": "to",
                                    "sDefaultContent": "",
                                    "sWidth": "20%",
                                    "bSortable": true},
                                {"mData": "totalPrice",
                                    "sDefaultContent": "",
                                    "sWidth": "20%",
                                    "bSortable": true}
                            ]
                        }
                );

                $("#btn_download").click(function () {
                    //alert("1");
                    var fromDate = $("#start").val();
                    var toDate = $("#end").val();
                    var schoolName = $("#schoolName").val();
                    var studentTransactionId = $("#transactionId").val();
                    var transStatus = $("#transStatus").val();
                    var studentId = $("#studentId").val();

                    window.location.href = '${baseURL}/summary/downloadReport.htm?fromDate=' + fromDate + '&toDate=' + toDate + '&schoolName=' + schoolName + '&studentTransactionId=' + studentTransactionId + '&transStatus=' + transStatus + '&studentId=' + studentId;
                });
                     
            });
        </script>
    </body>


</html>
