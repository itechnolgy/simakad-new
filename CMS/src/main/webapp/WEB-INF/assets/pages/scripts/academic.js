var AcademicPage = function() {
    var initDatePicker = function() {
        $('.date-picker').datepicker({
            autoclose: true,
            format: "dd MM yyyy"
        });
    };

    var handleEditRegistration = function() {
        $('#edit-reg-form').validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                period: {
                    required: true
                },
                startAt: {
                    required: true
                },
                endAt: {
                    required: true
                }
            },
            highlight: function(element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            unhighlight: function (element) {
                $(element).closest('.form-group').removeClass('has-error');
            },
            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },
            errorPlacement: function(error, element) {
                error.insertAfter(element);
            }
        });
    };

    var handleDocumentValidation = function() {
        $(".btn-accept").on('click', function() {
            var acceptId = $(this).data().id;
            $("#accept-id").val(acceptId);
            $("#accept-modal").modal('show');
        });

        $(".btn-reject").on('click', function() {
            var rejectId = $(this).data().id;
            $("#reject-id").val(rejectId);
            $("#reject-modal").modal('show');
        });
    };

    var handleNewStudentResultValidation = function() {
        $(".btn-accept").on('click', function() {
            var acceptId = $(this).data().id;
            $("#accept-id").val(acceptId);
            $("#accept-modal").modal('show');
        });

        $(".btn-reject").on('click', function() {
            var rejectId = $(this).data().id;
            $("#reject-id").val(rejectId);
            $("#reject-modal").modal('show');
        });
    };

    return {
        editRegistration: function() {
            initDatePicker();
            handleEditRegistration();
        },
        documentValidation: function() {
            handleDocumentValidation();
        },
        newStudentResultValidation: function() {
            handleNewStudentResultValidation();
        }
    };
}();