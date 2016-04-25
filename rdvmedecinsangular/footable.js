/**
 * Created by GuillaumeD on 25/04/2016.
 */
angular.module("rdvmedecins").directive('footable', ['$timeout', 'utils', function ($timeout, utils) {
    return {
        link: function (scope, element, attrs) {
            utils.debug("directive footable");
            $timeout(function () {
                $("#creneaux").footable();
            })
        }
    }

}]);