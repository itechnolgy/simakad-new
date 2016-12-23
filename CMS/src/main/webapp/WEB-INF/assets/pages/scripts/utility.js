var Utility = function() {
    var handleAjaxSetupHeader = function(headerKey, headerValue) {
        var headers = {};
        headers[headerKey] = headerValue;

        $.ajaxSetup({
            headers: headers
        });
    };

    return {
        ajaxSetupHeader: function(headerKey, headerValue) {
            handleAjaxSetupHeader(headerKey, headerValue);
        }
    }
}();