/**
 * Created by GuillaumeD on 25/04/2016.
 */
angular.module("rdvmedecins").directive("errors", ['utils', function (utils) {
    //instance de la directive retournée
    return {
        //élément HTML
        restrict: "E",
        //url du fragment
        templateUrl: "errors.html",
        //scope unique à chaque instance de la directive
        scope: true,
        //fonction lien avec le document
        link: function (scope, element, attrs) {
            //à chaque fois que attr["model"] change, le modèle de la page doit changer également
            scope.$watch(attrs["model"], function (newValue) {
                utils.debug("[errors] watch newValue", newValue);
                scope.model = newValue;
            });
        }
    }
}]);