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

    var initUploadView = function() {
        $("#upload-data").hide();
        $("#btn-submit").hide();
        $("#upload-table").html("");
    };

    var handleUpload = function() {
        $("#upload-form").validate({
            errorElement: 'span',
            errorClass: 'help-block',
            focusInvalid: false,
            rules: {
                type: {
                    required: true
                },
                document: {
                    required: true
                },
                file: {
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

    var paymentType = {
        BIAYA_PENDAFTARAN : "Registration",
        BIAYA_UANG_MASUK : "BP3",
        smt1: "Semester 1"
    };

    var documentType = {
        TOEFL : "TOEFL",
        IJAZAH : "Ijazah",
        RAPOR : "Rapor"
    };

    var handleAjaxUpload = function(type) {
        if(type != '') {
            $.ajax({
                url: '/pmb/upload/' + type,
                dataType: 'json',
                method: 'GET',
                beforeSend: function() {
                    App.blockUI({animate: true});
                    initUploadView();
                },
                error: function() {
                    App.unblockUI();
                },
                success: function(data) {
                    var uploadData = $("#upload-data");
                    var documentSelect = uploadData.find("#document-upload");

                    documentSelect.html("");
                    documentSelect.append($("<option></option>")
                        .attr({value: ""})
                        .html("-- Please Select --")
                    );

                    App.unblockUI();

                    if(type == 'pym') {
                        documentSelect.append(
                            $("<option></option>")
                                .attr({value: "BIAYA_PENDAFTARAN"})
                                .html("Registration")
                        );
                        documentSelect.append(
                            $("<option></option>")
                                .attr({value: "BIAYA_UANG_MASUK"})
                                .html("BP3")
                        );
                        documentSelect.append(
                            $("<option></option>")
                                .attr({value: "smt1"})
                                .html("Semester 1")
                        );
                    } else if (type == 'doc') {
                        documentSelect.append(
                            $("<option></option>")
                                .attr({value: "TOEFL"})
                                .html("TOEFL")
                        );
                        documentSelect.append(
                            $("<option></option>")
                                .attr({value: "IJAZAH"})
                                .html("Ijazah")
                        );
                        documentSelect.append(
                            $("<option></option>")
                                .attr({value: "RAPOR"})
                                .html("Rapor")
                        );
                    } else {
                        initUploadView();
                        return false;
                    }

                    uploadData.show();
                    $("#btn-submit").show();

                    var uploadList = data.data;
                    for(var i = 0;i < uploadList.length;i++) {
                        var uploadType = (type == 'pym') ? paymentType[uploadList[i].type] : documentType[uploadList[i].type];
                        var uploadAt = (uploadList[i].uploadAt == null) ? "" : moment(uploadList[i].uploadAt).format("DD MMMM YYYY HH:mm");
                        var downloadFile = (uploadList[i].file == null) ? "" : $("<a></a>").attr({
                            href: uploadList[i].file,
                            class: 'btn blue btn-xs'
                        }).html("<i class='fa fa-download'></i> Download");
                        var status = (uploadList[i].status == null) ? "" :
                            (uploadList[i].status == "PENDING") ? "Pending" :
                                (uploadList[i].status == "ACCEPTED") ? "Accepted" : "Rejected";


                        $("#upload-table").append(
                            $("<tr></tr>")
                                .append($("<td></td>").html((i + 1) + "."))
                                .append($("<td></td>").html(uploadType))
                                .append($("<td></td>").html(uploadAt))
                                .append($("<td></td>").html(downloadFile))
                                .append($("<td></td>").html(status))
                                .append($("<td></td>").html(uploadList[i].reason))
                        );

                        if(uploadList[i].status == 2) {
                            documentSelect.find("option[value='" + uploadList[i].type + "']").remove();
                        }
                    }
                }
            });
        } else {
            initUploadView();
        }
    };

    var handleSelectType = function() {
        $("#type-upload").on('change', function() {
            var value = $(this).val();

            handleAjaxUpload(value);
        });
    };

    var initSelectType = function() {
        var value = $("#type-upload").val();
        handleAjaxUpload(value);
    };

    return {
        profile: function() {
            initDatePicker();
            handleProfile();
        },
        upload: function() {
            initUploadView();
            handleSelectType();
            handleUpload();
        }
    };
}();