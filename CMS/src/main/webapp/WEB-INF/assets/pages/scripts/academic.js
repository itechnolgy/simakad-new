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

    return {
        editRegistration: function() {
            initDatePicker();
            handleEditRegistration();
        }
    };
}();