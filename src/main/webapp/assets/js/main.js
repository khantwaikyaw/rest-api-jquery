/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    var tbody = $('tbody#data-container');

    // get data from REST api.
    $.get('/api/guitars', function (data) {
        // check out javascript console to observer data from the server.
        console.debug(data);
        // loop through the data.
        $.each (data, function (index, guitar) {
            tbody.append(
                $('<tr />')
                    .append($('<th />').text(guitar.id))
                    .append($('<td />').text(guitar.brand))
                    .append($('<td />').text(guitar.type))
                    .append($('<td />')
                        .append(
                            $('<button />')
                                .addClass('btn btn-xs btn-primary btn-student')
                                .data('id', guitar.id)
                                .attr('data-toggle', 'modal')
                                .attr('data-target', '.bs-student-modal')
                            .append($('<span />').addClass('glyphicon glyphicon-eye-open'))
                        )
                    )
            );
        });

        // Student details button click event handler.
        $('.btn-student').click (function () {
            console.debug($(this).data('id'));
        });

        // Bootstrap modal pop up event (on event) handler.
        $('.bs-student-modal').on('show.bs.modal', function (e) {
            var triggerButton = $(e.relatedTarget);
            var id = triggerButton.data('id');
            $.get('/api/guitars/' + id, function (data) {
                console.debug(data);
                $('#student-details-id').text(data.id);
                $('#student-details-name').text(data.brand);
                $('#student-details-age').text(data.type);
      
            });
        });
//
        // ADD New
       $('#btn-Add').click(function(){
           var guitar = {};
           guitar.id = parseInt($('#id').val());
           guitar.brand = $('#brand').val();
           guitar.type = $('#type').val();
           
           $.ajax({
               url:"/api/guitars",
               type:"post",
               data: JSON.stringify(guitar),
               contentType:"application/json; charset=utf-8",
               dataType:"JSON",
               success:function(result){
                   if(result){
                       alert("Success");
                   }
               }
           });
       });
    });
});
