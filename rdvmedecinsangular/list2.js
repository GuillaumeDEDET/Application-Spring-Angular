/**
 * Created by GuillaumeD on 25/04/2016.
 */
angular.module("rdvmedecins").directive("list2", ['utils', '$timeout', function(utils, $timeout){
    //instance de la directive retournée
    return {
        //élément HTML
        restrict: "E",
        //url du fragment
        templateUrl: "list.html",
        //scope unique à chaque instance de la directive
        scope: true,
        //fonction lien avec le document
        link: function (scope, element, attrs){
           // à chaque fois que attrs["model"] change, le modèle de la directive doit changer également
            scope.$watch(attrs["model"], function (newValue) {
                utils.debug("directive list2 newValue", newValue);
                // on met à jour le modèle de la directive
                scope.model = newValue;
                $timeout(function () {
                    $('#' + scope.model.id).selectpicker('refresh');
                })
            });
        }
    }
}]);