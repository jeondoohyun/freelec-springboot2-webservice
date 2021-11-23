var main = {
    init : function() {
        var _this = this;
        $('#btn-save').on('click', function() {     // $('#btn-save').on('click', function() {  은 btn-save란 id를 가진 HTML 엘리먼트에 click 이벤트가 발생 할때 save()을 실행.
            _this.save();
        });

        $('#btn-update').on('click', function() {   // id값 앞에 #가 붙는다.
            _this.update();
        });

        $('#btn-delete').on('click', function() {
            _this.delete();
        });
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type : 'PUT',   // PostsApiController에 있는 API에서 이미 @PutMapping으로 선언했기 때문에 PUT을 사용해야 한다. REST의 CRUD는 HTTP Method의 다음과 같이 매핑된다. Create-post, Read-get, Update-put, Delete-delete
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type : 'DELETE',
            url : '/api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function() {
            alert(JSON.stringify(error));
        });
    }
};

main.init();