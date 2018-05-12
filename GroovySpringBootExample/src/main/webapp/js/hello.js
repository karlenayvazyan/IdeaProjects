function article($scope, $http) {
    $http.get('http://localhost:8086/article/get').success(function (data) {
        $scope.articles = data;
    });

    $scope.deleteArticleSubmit = function(id) {
        var data = id;
        $http.post('http://localhost:8086/article/delete', data).success(function (data, status, headers, config) {
            $scope.PostDataResponse = data;
            var index = -1;
            var comArr = eval($scope.articles);
            for(var i = 0; i < comArr.length; i++) {
                if(comArr[i].id === id) {
                    index = i;
                    break;
                }
            }
            if(index === -1) {
                alert("Something gone wrong");
            }
            $scope.articles.splice(index, 1);
        });
    }

    $scope.addArticleSubmit = function () {
        var data = JSON.stringify({
            title: $scope.title,
            comment: $scope.comment
        });

        $http.post('http://localhost:8086/article/add', data).success(function (data, status, headers, config) {
            $scope.PostDataResponse = data;
            $scope.articles.push({'title': data.title, 'comment': data.comment, 'id': data.id});
            $scope.name='';
            $scope.employees='';
            $scope.headoffice='';
        });
    }
}