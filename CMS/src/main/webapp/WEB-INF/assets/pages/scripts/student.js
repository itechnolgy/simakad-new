var StudentPage = function() {

    var handleTranscript = function() {
        $('#semester-transcript').on('change', function() {
            var semester = $(this).val();
            $('#table-transcript').html('');

            if(semester.length == "") {
                return false;
            }

            $.ajax({
                url: '/student/transcript/' + semester,
                dataType: 'json',
                method: 'GET',
                beforeSend: function() {
                    App.blockUI({animate: true});
                },
                error: function() {
                    App.unblockUI();
                },
                success: function(data) {
                    App.unblockUI();

                    data = data.transcript;
                    var length = data.length;
                    for(var iLoop = 0;iLoop < length;iLoop++) {
                        $("#table-transcript").append(
                            $("<tr></tr>")
                                .append($("<td></td>").html(data[iLoop].courseName))
                                .append($("<td></td>").html(data[iLoop].sks))
                                .append($("<td></td>").html(data[iLoop].assignment))
                                .append($("<td></td>").html(data[iLoop].midExam))
                                .append($("<td></td>").html(data[iLoop].finalExam))
                                .append($("<td></td>").html(data[iLoop].grade))
                        );
                    }
                }
            });
        });
    };

    return {
        transcript: function() {
            handleTranscript();
        }
    };

}();
