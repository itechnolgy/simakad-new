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

    var handleLectureList = function () {
        $(".btn-delete").on('click', function() {
            var lectureId = $(this).data().id;
            $("#lecture-id").val(lectureId);
            $("#delete-modal").modal('show');
        });
    };
    
    var handleLectureValidation = function() {
        $("#lecture-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                name: {
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
                if(element.attr("type") == "radio") {
                    error.insertAfter(element.closest('.radio-list'))
                } else {
                    error.insertAfter(element);
                }
            }
        });
    };

    var handleCourseList = function () {
        $(".btn-delete").on('click', function() {
            var courseId = $(this).data().id;
            $("#course-id").val(courseId);
            $("#delete-modal").modal('show');
        });
    };

    var handleCourseValidation = function() {
        $("#course-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                name: {
                    required: true
                },
                degreeId: {
                    required: true
                },
                sks: {
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
                if(element.attr("type") == "radio") {
                    error.insertAfter(element.closest('.radio-list'))
                } else {
                    error.insertAfter(element);
                }
            }
        });
    };

    var handleClassKrsList = function() {
        $(".btn-delete").on('click', function() {
            var classId = $(this).data().id;
            $("#class-id").val(classId);
            $("#delete-modal").modal('show');
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
        },
        lectureList: function() {
            handleLectureList();
        },
        lectureValidation: function() {
            handleLectureValidation();
        },
        courseList: function() {
            handleCourseList()
        },
        courseValidation: function() {
            handleCourseValidation();
        },
        classList: function() {
            handleClassKrsList();
        }
    };
}();