/**
 * Created by GuillaumeD on 25/04/2016.
 */
angular.module("rdvmedecins").directive("waiting", ['utils', function (utils) {
    //instance de la directive retournée
    return {
        //élément HTML
        restrict: "E",
        //url du fragment
        templateUrl: "waiting.html",
        //scope unique à chaque instance de la directive
        scope: true,
        //la fonction lien avec le document
        link: function (scope, element, attrs) {
            // à chaque fois que attr["model"] chnge, le modèle de la page doit changer également
            scope.$watch(attrs["model"], function (newValue) {
                utils.debug("[waiting] watch newValue", newValue);
                scope.model = newValue;
            });
        }
    }
}]);