var AccountantPage = function() {

    var handleRegistrationValidation = function() {
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
        registerValidation: function() {
            handleRegistrationValidation();
        }
    };

}();