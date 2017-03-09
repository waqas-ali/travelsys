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

        <style>
            .loader-modal {
                display: none;
                position: fixed;
                z-index: 1000;
                top: 0;
                left: 0;
                height: 100%;
                width: 100%;
                background-position: center;
                background: rgba(255, 255, 255, .8) url('${baseURL}/assets/images/ajax-loader.gif') 50%
                    50% no-repeat;
            }
        </style>

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
                            <div class="col-lg-2">
                                <div class="row">
                                    <input type="button" class="btn btn-lg btn-success btn-block col-lg-2" value="Download"  id="btn_download"/>
                                </div>
                                <div class="row">&nbsp;</div>
                                <div class="row">
                                    <input type="button" class="btn btn-lg btn-success btn-block col-lg-2" value="Email"  id="btn_email"/>
                                </div>
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
            <div class="loader-modal" id="loading"></div>
        </div>
        <%@include file="../includes/footer.jspf" %>
        <script>
            $(document).ready(function () {

                $('#report-list').DataTable(
                        {
                            "responsive": true,
                            "filter": true,
                            "bProcessing": true,
                            "serverSide": false,
                            "bStateSave": true,
                            "aLengthMenu": [[5, 20, 50, 100, 5000], [5, 20, 50, 100, "All"]],
                            "ajax": "${baseURL}/summary/getOrdersByUser.htm",
                            "aoColumns": [
                                {"mData": "tickets",
                                    "sDefaultContent": "",
                                    "sWidth": "25%"},
                                {"mData": "from",
                                    "sDefaultContent": "",
                                    "sWidth": "25%"},
                                {"mData": "to",
                                    "sDefaultContent": "",
                                    "sWidth": "25%",
                                    "bSortable": true},
                                {"mData": "totalPrice",
                                    "sDefaultContent": "",
                                    "sWidth": "25%",
                                    "bSortable": true}
                            ]
                        }
                );

                $("#btn_download").click(function () {
                    window.open('${baseURL}/summary/downloadSummary.htm', '_blank');
                });

                $("#btn_email").click(function () {

                    $("#loading").css("display", "block");
                    $.ajax({
                        contentType: 'application/json; charset=utf-8',
                        type: 'POST',
                        url: 'emailSummary.htm?',
                        dataType: 'json',
                        async: true,
                        success: function (response) {
                            $("#loading").css("display", "none");
                            swal("Response!", response.message, response.status);

                        },
                        error: function () {
                            $("#loading").css("display", "none");
                            swal("Oops!", "Sometime went wrong. please try again ", "error");

                        }
                    });
                });

            });
        </script>
    </body>


</html>
