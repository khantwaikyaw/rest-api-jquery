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
                        .append(
                            $('<button />')
                                .addClass('btn btn-xs btn-danger btn-delete')
                                .data('id',guitar.id)
                                .html('X')
                          
                        )
                        .append(
                            $('<button />')
                                .addClass('btn btn-xs btn-info btn-update')
                                .data('id',guitar.id)
                                .text('update')
                                .attr('data-toggle', 'modal')
                                .attr('data-target', '.bs-update-modal')
                        )
                    )
            );
        });
        
        //Delete function
        $('.btn-delete').click (function () {
//            alert($(this).data('id'));
            var delId = $(this).data('id');
            
            $.ajax({
               url:"/api/guitars/"+delId,
               type:"delete",
               contentType:"application/json; charset=utf-8",
               success:function(){
                  
                       alert("Success");
                   
               }
            });
        });

        // Student details button click event handler.
        $('.btn-student').click (function () {
            console.debug($(this).data('id'));
        });
        
         // Bootstrap modal pop up event (on event) handler.
        $('.bs-update-modal').on('show.bs.modal', function (e) {
            var triggerButton = $(e.relatedTarget);
            var id = triggerButton.data('id');
            $.get('/api/guitars/' + id, function (data) {
                console.debug(data);
                $('#gt-id').val(data.id);
                $('#gt-brand').val(data.brand);
                $('#gt-type').val(data.type);
      
            });
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
        
        //Update
        $('#btn-update').click(function(){
            var gt = {};
            gt.brand = $('#gt-brand').val();
            gt.type = $('#gt-type').val();
            console.log($('#gt-id').val());
            $.ajax({
                url:"/api/guitars/"+$('#gt-id').val(),
                type:"put",
                data: JSON.stringify(gt),
               contentType:"application/json; charset=utf-8",
               dataType:"JSON",
               success:function(result){
                   if(result){
                       alert("Success");
                   }
               }
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
