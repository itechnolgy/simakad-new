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

    var handleClassKrsValidation = function() {
        $("#krs-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: ":hidden:not(.select2me)",
            rules: {
                lectureId: {
                    required: true
                },
                degreeId: {
                    required: true
                },
                courseId: {
                    required: true
                },
                scheduleDay: {
                    required: true
                },
                scheduleTime: {
                    required: true
                },
                quota: {
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
                } else if (element.hasClass("select2custom")) {
                    element.closest(".col-md-9").append(error);
                } else {
                    error.insertAfter(element);
                }
            }
        });
    };

    var handlePopulateLecture = function() {
        $.ajax({
            url: '/academic/lectures',
            dataType: 'json',
            method: 'GET',
            beforeSend: function () {
                App.blockUI({animate: true});
            },
            error: function () {
                App.unblockUI();
            },
            success: function(data) {
                App.unblockUI();
                var lectureList = $("#lectureId");

                lectureList.html("").append($("<option></option>", {"value": ""}));
                $.each(data.data, function(key, value) {
                    lectureList.append($("<option></option>", {"value": value.id}).html(value.lecture_name));
                });

                lectureList.select2({
                    allowClear: true,
                    placeholder: 'Select Lecture'
                });
            }
        });
    };

    var handleDegreeChange = function() {
        $("#courseId").select2({
            allowClear: true,
            placeholder: 'Select Course'
        });

        var degreeList = $("#degreeId");
        handlePopulateCourse(degreeList.val(), true);

        degreeList.change(function() {
            handlePopulateCourse($(this).val(), true);
        });
    };

    var handlePopulateCourse = function(degreeId, courseInitial) {
        var courseList = $("#courseId");

        if(courseInitial) courseList.select2("destroy");
        courseList.html("").append($("<option></option>", {"value": ""}));

        if(degreeId.length == 0) {
            courseList.select2({
                allowClear: true,
                placeholder: 'Select Course'
            });

            return false;
        }

        $.ajax({
            url: '/academic/course/' + degreeId,
            dataType: 'json',
            method: 'GET',
            beforeSend: function () {
                App.blockUI({animate: true});
            },
            error: function () {
                App.unblockUI();
            },
            success: function(data) {
                App.unblockUI();

                $.each(data.data, function(key, value) {
                    courseList.append($("<option></option>", {"value": value.id}).html(value.course_name));
                });

                courseList.select2({
                    allowClear: true,
                    placeholder: 'Select Course'
                });
            }
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
        },
        classValidation: function() {
            handlePopulateLecture();
            handleDegreeChange();
            handleClassKrsValidation();
        }
    };
}();