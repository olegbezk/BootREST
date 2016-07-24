angular.module('app', [])

.controller('controller', function($scope, $http) {

    var data = {
        title: "",
        number: ""
    };

    $scope.showData = function() {
        $http.get('http://localhost:8080/data/all/')
            .then(function(res){
                $scope.results = res.data;
            });
    }

    $scope.showDataById = function() {

        $scope.showData;

        $http.get('http://localhost:8080/data/' + $scope.idUn)
            .then(function(res){
                $scope.item = res.data;
            });
            $scope.idUn = "";
    };

    $scope.deleteData = function() {

            $http.delete('http://localhost:8080/data/delete/' + $scope.id)
            .success(function (data, status, headers) {
                $scope.serverResponse = data;
            })
            .error(function (data, status, headers) {
                $scope.serverResponse = data;
            });

            $scope.showData

            $scope.id = "";
    };

    $scope.submitData = function() {

         data = $scope.formData

         if (data.number == 0) {
             return;
         }

         if(!isFinite(data.number)) {
             alert("Insert a number in the number field, please!")
         }

         $http.post(
                'http://localhost:8080/data/add/',
                JSON.stringify(data),
                {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
            ).success(function (response) {
                $scope.postResult = response;
            }).error(function (response) {

            });

            $scope.showData

            data.title = "";
            data.number = "";
    }

});



