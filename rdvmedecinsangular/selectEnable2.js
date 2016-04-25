/**
 * Created by GuillaumeD on 25/04/2016.
 */
angular.module("rdvmedecins").directive('selectEnable2', ['$timeout', 'utils', function ($timeout, utils) {
    return {
        link: function (scope, element, attrs) {
            utils.debug("directive selectEnable2 attrs")
            $timeout(function () {
                $('#' + attrs['id']).selectpicker();
            })
        }
    }
}]);
