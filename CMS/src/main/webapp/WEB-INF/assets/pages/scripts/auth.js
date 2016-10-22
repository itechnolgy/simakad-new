var AuthPage = function() {

    var handleLogin = function() {
        $("#login-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                username: {
                    required: true
                },
                password: {
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
                error.insertAfter(element.closest('.input-group'));
            }
        });
    };

    var handleForgotPassword = function() {
        $("#forgot-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                email: {
                    required: true,
                    email: true
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
                error.insertAfter(element.closest('.input-group'));
            }
        });
    };

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

    var handleRegister = function() {
        $("#register-form").validate({
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

    var initChangePasswordValidation = function() {
        $.validator.addMethod('notEqualTo', function(value, element, param) {
            var target = $(param);
            return target.val() !== value;
        }, 'This field must be not same with other field.');
    };

    var handleChangePassword = function() {
        $("#change-password-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                old_password: {
                    required: true
                },
                new_password: {
                    required: true,
                    minlength: 8,
                    notEqualTo: 'input[name="old_password"]'
                },
                confirm_new_password: {
                    required: true,
                    equalTo: 'input[name="new_password"]'
                }
            },
            messages : {
                confirm_new_password: {
                    equalTo: 'This field must be same with New Password field.'
                },
                new_password: {
                    notEqualTo: 'New Password cannot be same with Old Password.'
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
            }
        });
    };

    var handlePreRegister = function() {
        $("#study-program").on('change', function() {
            $("#study-program-form").submit();
        });
    };

    return {
        login: function() {
            handleLogin();
        },
        forgotPassword: function() {
            handleForgotPassword();
        },
        register: function() {
            initDatePicker();
            handleRegister();
        },
        changePassword: function() {
            initChangePasswordValidation();
            handleChangePassword();
        },
        preRegister: function() {
            handlePreRegister();
        }
    };

}();