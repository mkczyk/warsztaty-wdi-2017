app.controller('myController', function($scope, $http) {
	
	$scope.hello = "Hello";
	$scope.books;
	$scope.orderBy = '-id';
	$scope.search = '';
	
	$scope.myFun = function() {
		return "hello2";
	}
	
	$scope.sortBy = function(parameter) {
		if($scope.orderBy ==parameter){
			$scope.orderBy="-"+parameter;
		}else{
			$scope.orderBy=parameter;
		}
		
	}
	
	$scope.getBooks = function() {
		$http.get('books').then(function(response) {
			$scope.books = response.data;
			console.log(response.data);
		})
	}
	
	$scope.addBook = function(book) {
		$http.post('books', book).then(function(response) {
			console.log("Dodało");
			$scope.getBooks();
		})
	}
	
	$scope.deleteBook = function(id) {
		$http.delete('books/' + id).then(function(response) {
			console.log("Usunelo");
			$scope.getBooks();
		})
	}
	
	$scope.newBook = {
			title : "Testowa ksiazka",
			author : "Testowy",
			description : "aaaaaaaaa"
	}
	
	$scope.getBooks();
	$scope.searchFor = function(){
		return {title:'aaaaa'}
	}
	
});

