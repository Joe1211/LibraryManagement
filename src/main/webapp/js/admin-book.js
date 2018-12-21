$('#submitbook').click(function(){
    var data = new FormData($("#subbook")[0]);
    $.ajax({
        type: 'post',
        url: 'api/books/add',
        data:data,
        contentType: false,
        processData: false,
        success: function (data) {

        }
    });
})
