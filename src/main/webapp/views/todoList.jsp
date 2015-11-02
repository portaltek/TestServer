<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" ng-app="todoApp">
<head>
<!-- <meta charset="utf-8"> -->
<title>My HTML File</title>

<link rel="stylesheet"
	href="<c:url value="/resources/default/css/bootstrap/bootstrap.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/resources/default/css/default/app.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/default/lib/angular/angular.js"/>"></script>
<script type="text/javascript"
    src="<c:url value="/resources/default/js/test.js"/>"></script>	

</head>
<body>

  <h2>Todo</h2>
    <div ng-controller="TodoListController as todoList">
      <span>{{todoList.remaining()}} of {{todoList.todos.length}} remaining</span>
      [ <a href="" ng-click="todoList.archive()">archive</a> ]
      <ul class="unstyled">
        <li ng-repeat="todo in todoList.todos">
          <input type="checkbox" ng-model="todo.done">
          <span class="done-{{todo.done}}">{{todo.text}}</span>
        </li>
      </ul>
      <form ng-submit="todoList.addTodo()">
        <input type="text" ng-model="todoList.todoText"  size="30"
               placeholder="add new todo here">
        <input class="btn-primary" type="submit" value="add">
      </form>
    </div>


</body>
</html>
