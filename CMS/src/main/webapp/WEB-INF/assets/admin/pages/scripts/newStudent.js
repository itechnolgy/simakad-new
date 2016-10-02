var NewStudentPage = function(){
    var initDatePicker = function() {
        var startDate = moment().month(0).date(1).year(1900).format("DD MMMM YYYY");
        var endDate = moment().format("DD MMMM YYYY");

        $('.date-picker').datepicker({
            autoclose: true,
            startDate: startDate,
            endDate: endDate,
            format: "dd MM yyyy"
        });
    };

    var handleProfile = function() {
        $("#profile-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                fullname: {
                    required: true,
                    maxlength: 255
                },
                identity: {
                    required: true
                },
                gender: {
                    required: true
                },
                dob: {
                    required: true
                },
                address: {
                    required: true
                },
                phone: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                email_confirmation: {
                    required: true,
                    equalTo: 'input[name="email"]'
                }
            },
            messages: {
                email_confirmation: {
                    equalTo: 'This field must be same with Email field.'
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
                if(element.attr("type") == "radio") {
                    error.insertAfter(element.closest('.radio-list'))
                } else {
                    error.insertAfter(element);
                }
            }
        });
    };

    return {
        profile: function() {
            initDatePicker();
            handleProfile();
        }
    };
}();