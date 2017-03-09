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
                            <h1 class="page-header">Offers
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
                                                    <th>From</th>
                                                    <th>To</th>
                                                    <th>Price</th>
                                                    <th>Currency</th>
                                                    <th>Action</th>
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
                            "ajax": "${baseURL}/offer/getOffers.htm",
                            "aoColumns": [
                                {"mData": "route.from",
                                    "sDefaultContent": "",
                                    "sWidth": "20%"},
                                {"mData": "route.to",
                                    "sDefaultContent": "",
                                    "sWidth": "20%"},
                                {"mData": "price.amount",
                                    "sDefaultContent": "",
                                    "sWidth": "20%",
                                    "bSortable": true},
                                {"mData": "price.currency",
                                    "sDefaultContent": "",
                                    "sWidth": "20%",
                                    "bSortable": true},
                                {"mData": "Action",
                                    "sDefaultContent": "",
                                    "sWidth": "20%",
                                    "bSortable": false}
                            ],
                            "aoColumnDefs": [
                                {
                                    "aTargets": [4],
                                    "fnCreatedCell": function (nTd, sData, oData, iRow, iCol) {
                                        var route = oData['route'];
                                        var price = oData["price"];
                                        var data = route.from + "," + route.to;
                                        //alert(price.currency);
                                        if ( typeof price.currency !== 'undefined' ) {
                                            var c = $('<button class="btn btn-info btn-sm" title="Buy" id="' + data + '"><i class="fa fa-plane"></i></button><span>&nbsp;&nbsp;</span>');
                                            c.on('click', function () {
                                                swal({
                                                    title: "Buy Tickets!",
                                                    text: "Please write number of tickets you want to purchase!",
                                                    type: "input",
                                                    showCancelButton: true,
                                                    closeOnConfirm: false,
                                                    animation: "slide-from-top",
                                                    inputPlaceholder: "Tickets"
                                                },
                                                function (inputValue) {
                                                    if (inputValue === false)
                                                        return false;

                                                    if (inputValue === "" || inputValue < 1) {
                                                        swal.showInputError("Please enter valid positive number!");
                                                        return false;
                                                    }
                                                    var data = c.attr("id");
                                                    var array = data.split(',');

                                                    var obj = {"from": array[0], "to": array[1], "amount": inputValue};
                                                    data = JSON.stringify(obj);
                                                    $("#loading").css("display", "block");
                                                    $.ajax(
                                                            {
                                                                contentType: 'application/json; charset=utf-8',
                                                                type: 'POST',
                                                                url: 'buyTicket.htm?',
                                                                dataType: 'json',
                                                                async: true,
                                                                data: data,
                                                                success: function (response) {
                                                                    $("#loading").css("display", "none");
                                                                    swal("Response!", response.message, response.status);
                                                                },
                                                                error: function () {
                                                                    $("#loading").css("display", "none");
                                                                    swal("Oops!", "Sometime went wrong. please try again ", "error");
                                                                }
                                                            }
                                                    );

                                                });
                                            });
                                            $(nTd).empty();
                                            $(nTd).prepend(c);
                                        }
                                        else {
                                            $(nTd).empty();
                                            $(nTd).prepend("You can't buy this ticket!");
                                        }
                                    }
                                }
                            ]
                        }
                );
            });
        </script>



    </body>


</html>
