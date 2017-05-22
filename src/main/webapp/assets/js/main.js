$(function () {
    var tbody = $('tbody#data-container');

    // get data from REST api.
    $.get('/api/students', function (data) {
        // check out javascript console to observer data from the server.
        console.debug(data);
        // loop through the data.
        $.each (data, function (index, student) {
            tbody.append(
                $('<tr />')
                    .append($('<th />').text(student.id))
                    .append($('<td />').text(student.name))
                    .append($('<td />').text(student.age))
                    .append($('<td />').text(student.gender))
                    .append($('<td />')
                        .append(
                            $('<button />')
                                .addClass('btn btn-xs btn-primary btn-student')
                                .data('id', student.id)
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
            var studentId = triggerButton.data('id');
            $.get('/api/students/' + studentId, function (data) {
                console.debug(data);
                $('#student-details-id').text(data.id);
                $('#student-details-name').text(data.name);
                $('#student-details-age').text(data.age);
                $('#student-details-gender').text(data.gender);
            });
        });

        // Clear the old data inside Bootstrap modal during hidden event.
        $('.bs-student-modal').on('hidden.bs.modal', function (e) {
            $('#student-details-id').text('');
            $('#student-details-name').text('');
            $('#student-details-age').text('');
            $('#student-details-gender').text('');
        });
    });
});