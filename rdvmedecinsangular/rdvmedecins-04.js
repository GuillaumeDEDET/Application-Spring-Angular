
//module Angular
angular.module("rdvmedecins", ['ui.bootstrap', 'ngLocale', 'pascalprecht.translate', 'base64']);

//configuration initiale
angular.module("rdvmedecins").config(['$translateProvider', function ($translateProvider) {
    //messages français
    $translateProvider.translations("fr", {
        msg_header: 'Cabinet Médical<br/>Les Médecins Associés',
        msg_langues: 'Langues',
        msg_agenda: 'Agenda de {{titre}} {{prenom}} {{nom}}<br/>le {{jour}}',
        msg_calendrier: 'Calendrier',
        msg_jour: 'Jour sélectionné : ',
        msg_meteo: "Aujourd'hui, il va pleuvoir...",
        msg_cancel: 'Annuler',
        msg_waiting: 'Opération en cours. Patientez...',
        msg_waiting_time_text: "Temps d'attente : ",
        msg_list_medecins: "Liste des médecins",
        msg_urlserver_label: "URL du service web : ",
        msg_login_label: "Login : ",
        msg_password_label: 'Mot de passe : ',
        error_unknown: "Erreur non identifiée",
        not_authorized: "Erreur d'authentification",
        server_not_available: "Serveur indisponible",
        msg_get_medecins_errors: "Les erreurs suivantes se sont produites lors du chargement de la liste des médecins",
        forbidden: "Accès refusé",
        not_http_error: "L'accès au serveur n'a pu être réalisé. Vérifiez sa disponibilité.",
        server_url: "URL du serveur",
        not_found: "Document non trouvé. Vérifiez l'URL du serveur"


    });
    // messages anglais
    $translateProvider.translations("en", {
        msg_header: 'The Associated Doctors',
        msg_langues: 'Languages',
        msg_agenda: "{{titre}} {{prenom}} {{nom}}'s Diary<br/> on {{jour}}",
        msg_calendrier: 'Calendar',
        msg_jour: 'Selected day: ',
        msg_meteo: 'Today, it will be raining...',
        msg_cancel: 'Cancel',
        msg_waiting: 'Opération in progress. Please wait...',
        msg_waiting_time_text: "Waiting time:",
        msg_list_medecins: "Doctors' list",
        msg_urlserver_label: "Web service URL:",
        msg_login_label: "Login:",
        msg_password_label: 'Password:',
        error_unknown: "Unknown error",
        not_authorized: "Authentification failure",
        server_not_available: "Unavailable server",
        msg_get_medecins_errors: "Following errors were met while loading the list of doctors.",
        forbidden: "Access denied",
        not_http_error: "Server access could not be achieved. Check its availability.",
        server_url: "Server URL",
        not_found: "Document not found. Check the server URL"

    });
    //langue par défaut
    $translateProvider.preferredLanguage("fr");
}]);

//services
angular.module("rdvmedecins").factory('config', function () {
    return {
        //messages à internationaliser
        msgWaitingInit: "msg_waiting_init",
        msgWaiting: "msg_waiting",
        waitingTimeText: 'msg_waiting_time_text',
        loadingError: "loading_error",
        canceledOperation: 'canceled_operation',
        getMedecinsErrors: 'msg_get_medecins_errors',
        getClientsErrors: 'get_clients_errors',
        getAgendaErrors: 'get_agenda_errors',
        selectMedecins: 'select_medecins',
        identification: 'identification',
        choixMedecinJourTitle: 'choixmedecinjour_title',
        agendaTitre: 'agenda_titre',
        selectClient: 'select_client',
        postRemoveErrors: 'post_remove_errors',
        resaTitre: 'resa_titre',
        chooseAClient: 'choose_a_client',
        postResaErrors: 'post_resa_errors',
        urlServerLabel: 'msg_urlserver_label',
        loginLabel: 'msg_login_label',
        passwordLabel: 'msg_password_label',
        listMedecins: 'msg_list_medecins',
        //urls du client
        urlLogin: "/login",
        urlHome: "/home",
        urlAgenda: "/agenda",
        urlResa: "/resa",
        //urls du serveur
        urlSvrMedecins: "getAllMedecins",
        urlSvrClients: "/getAllClients",
        urlSvrAgenda: "/getAgendaMedecinJour",
        urlSvrResa: "/reserver",
        urlSvrResaAdd: "/ajouterRv",
        urlSvrResaRemove: "/supprimerRv",
        //délai d'attente maximal pour les appels http en millisecondes
        timeout: 1000,
        //temps d'attente avant une tâche
        waitingTimeBeforeTask: 0,
        //mode debug
        debug: true,
        //le dictionnaire des locales
        locales: {
            fr: {
                "DATETIME_FORMATS": {
                    "AMPMS": [
                        "AM",
                        "PM"
                    ],
                    "DAY": [
                        "dimanche",
                        "lundi",
                        "mardi",
                        "mercredi",
                        "jeudi",
                        "vendredi",
                        "samedi"
                    ],
                    "ERANAMES": [
                        "avant J\u00e9sus-Christ",
                        "apr\u00e8s J\u00e9sus-Christ"
                    ],
                    "ERAS": [
                        "av. J.-C.",
                        "ap. J.-C."
                    ],
                    "FIRSTDAYOFWEEK": 0,
                    "MONTH": [
                        "janvier",
                        "f\u00e9vrier",
                        "mars",
                        "avril",
                        "mai",
                        "juin",
                        "juillet",
                        "ao\u00fbt",
                        "septembre",
                        "octobre",
                        "novembre",
                        "d\u00e9cembre"
                    ],
                    "SHORTDAY": [
                        "dim.",
                        "lun.",
                        "mar.",
                        "mer.",
                        "jeu.",
                        "ven.",
                        "sam."
                    ],
                    "SHORTMONTH": [
                        "janv.",
                        "f\u00e9vr.",
                        "mars",
                        "avr.",
                        "mai",
                        "juin",
                        "juil.",
                        "ao\u00fbt",
                        "sept.",
                        "oct.",
                        "nov.",
                        "d\u00e9c."
                    ],
                    "STANDALONEMONTH": [
                        "Janvier",
                        "F\u00e9vrier",
                        "Mars",
                        "Avril",
                        "Mai",
                        "Juin",
                        "Juillet",
                        "Ao\u00fbt",
                        "Septembre",
                        "Octobre",
                        "Novembre",
                        "D\u00e9cembre"
                    ],
                    "WEEKENDRANGE": [
                        5,
                        6
                    ],
                    "fullDate": "EEEE d MMMM y",
                    "longDate": "d MMMM y",
                    "medium": "d MMM y HH:mm:ss",
                    "mediumDate": "d MMM y",
                    "mediumTime": "HH:mm:ss",
                    "short": "dd/MM/y HH:mm",
                    "shortDate": "dd/MM/y",
                    "shortTime": "HH:mm"
                },
                "NUMBER_FORMATS": {
                    "CURRENCY_SYM": "\u20ac",
                    "DECIMAL_SEP": ",",
                    "GROUP_SEP": "\u00a0",
                    "PATTERNS": [
                        {
                            "gSize": 3,
                            "lgSize": 3,
                            "maxFrac": 3,
                            "minFrac": 0,
                            "minInt": 1,
                            "negPre": "-",
                            "negSuf": "",
                            "posPre": "",
                            "posSuf": ""
                        },
                        {
                            "gSize": 3,
                            "lgSize": 3,
                            "maxFrac": 2,
                            "minFrac": 2,
                            "minInt": 1,
                            "negPre": "-",
                            "negSuf": "\u00a0\u00a4",
                            "posPre": "",
                            "posSuf": "\u00a0\u00a4"
                        }
                    ]
                },
                "id": "fr-fr",
                "localeID": "fr_FR",
                "pluralCat": function(n, opt_precision) {  var i = n | 0;  if (i == 0 || i == 1) {    return PLURAL_CATEGORY.ONE;  }  return PLURAL_CATEGORY.OTHER;}
            },
            en: {
                "DATETIME_FORMATS": {
                    "AMPMS": [
                        "AM",
                        "PM"
                    ],
                    "DAY": [
                        "Sunday",
                        "Monday",
                        "Tuesday",
                        "Wednesday",
                        "Thursday",
                        "Friday",
                        "Saturday"
                    ],
                    "ERANAMES": [
                        "Before Christ",
                        "Anno Domini"
                    ],
                    "ERAS": [
                        "BC",
                        "AD"
                    ],
                    "FIRSTDAYOFWEEK": 6,
                    "MONTH": [
                        "January",
                        "February",
                        "March",
                        "April",
                        "May",
                        "June",
                        "July",
                        "August",
                        "September",
                        "October",
                        "November",
                        "December"
                    ],
                    "SHORTDAY": [
                        "Sun",
                        "Mon",
                        "Tue",
                        "Wed",
                        "Thu",
                        "Fri",
                        "Sat"
                    ],
                    "SHORTMONTH": [
                        "Jan",
                        "Feb",
                        "Mar",
                        "Apr",
                        "May",
                        "Jun",
                        "Jul",
                        "Aug",
                        "Sep",
                        "Oct",
                        "Nov",
                        "Dec"
                    ],
                    "STANDALONEMONTH": [
                        "January",
                        "February",
                        "March",
                        "April",
                        "May",
                        "June",
                        "July",
                        "August",
                        "September",
                        "October",
                        "November",
                        "December"
                    ],
                    "WEEKENDRANGE": [
                        5,
                        6
                    ],
                    "fullDate": "EEEE, MMMM d, y",
                    "longDate": "MMMM d, y",
                    "medium": "MMM d, y h:mm:ss a",
                    "mediumDate": "MMM d, y",
                    "mediumTime": "h:mm:ss a",
                    "short": "M/d/yy h:mm a",
                    "shortDate": "M/d/yy",
                    "shortTime": "h:mm a"
                },
                "NUMBER_FORMATS": {
                    "CURRENCY_SYM": "$",
                    "DECIMAL_SEP": ".",
                    "GROUP_SEP": ",",
                    "PATTERNS": [
                        {
                            "gSize": 3,
                            "lgSize": 3,
                            "maxFrac": 3,
                            "minFrac": 0,
                            "minInt": 1,
                            "negPre": "-",
                            "negSuf": "",
                            "posPre": "",
                            "posSuf": ""
                        },
                        {
                            "gSize": 3,
                            "lgSize": 3,
                            "maxFrac": 2,
                            "minFrac": 2,
                            "minInt": 1,
                            "negPre": "-\u00a4",
                            "negSuf": "",
                            "posPre": "\u00a4",
                            "posSuf": ""
                        }
                    ]
                },
                "id": "en-us",
                "localeID": "en_US",
                "pluralCat": function(n, opt_precision) {  var i = n | 0;  var vf = getVF(n, opt_precision);  if (i == 1 && vf.v == 0) {    return PLURAL_CATEGORY.ONE;  }  return PLURAL_CATEGORY.OTHER;}
            }}
    };
});

//utilitaires
// $q pour les tâches asynchrones
angular.module("rdvmedecins").factory('utils', ['config', '$timeout', '$q', function (config, $timeout, $q) {
    //affichage de la représentation Json d'un objet
    function debug(message, data) {
        if(config.debug){
            var text = data ? message + " : " + angular.toJson(data) : message;
            console.log(text);
        }
    }

    //attente
    function waitForSomeTime(milliseconds) {
        //attente asynchrone de millisecondes milli-secondes
        var task = $q.defer();
        $timeout(function () {
            task.resolve();
        }, milliseconds);
        //on retourne la tâche
        return task;
    }

    // analyse des erreurs dans la réponse du serveur JSON
    function getErrors(data){
        // data {err:n, messages:[]}, err!=0
        // erreurs
        var errors = [];
        // code d'erreur
        var err = data.err;
        switch (err) {
            case 2 :
                //not authorized
                errors.push('not_authorized');
                break;
            case 3 :
                //forbidden
                errors.push('forbidden');
                break;
            case 4 :
                //erreur locale
                errors.push('not_http_error');
                break;
            case 6 :
                // document non trouvé
                errors.push('not_found');
                break;
            default :
                // autres cas
                errors = data.messages;
                break;
        }
        //si pas de msg, on en met un
        if (! errors || errors.length == 0){
            errors=['error_unknown'];
        }
        //on rend la liste des erreurs
        return errors;
    }

    //instance du service
    return {
        debug: debug,
        waitForSomeTime: waitForSomeTime,
        getErrors: getErrors
    }
}]);

//DAO
angular.module("rdvmedecins").factory('dao', ['$http', '$q', 'config', '$base64', 'utils',
    function ($http, $q, config, $base64, utils){

        //logs
        utils.debug("[dao] init");

        //méthodes privées
        //obtenir des données auprès du service web
        function getData(serverUrl, username, password, urlAction, info) {
            //opération asynchrone
            var task = $q.defer();
            //url requête HTTP
            var url = serverUrl + "/" + urlAction;
            // authentification basique
            var basic = "Basic " + $base64.encode(username + ":" + password);
            // la réponse
            var reponse;
            // les requêtes http doivent être toutes authentifiées
            var headers = $http.defaults.headers.common;
            headers.Authorization = basic;
            // on fait la requête HTTP
            var promise;
            if(info) {
                promise = $http.post(url, info, {timeout: config.timeout});
            } else {
                promise = $http.get(url, {timeout: config.timeout});
            }
            promise.then(success, failure);
            //on retourne la tâche elle-même afin qu'elle puisse être annulée
            return task;

            //success
            function success(response) {
                //response.data={sataus:0, data:[med1, med2, ...]} ou {status:x, data:[msg1, msg2, ...]
                utils.debug("[dao] getData[" + urlAction + "] success reponse", response);
                //réponse
                var payLoad = response.data;
                reponse = payLoad.status == 0 ? {err: 0, data: payLoad.data} : {err: 1, messages: payLoad.data};
                //on rend la réponse
                task.resolve(reponse);
            }

            //failure
            function failure(response){
                utils.debug("[dao] getData[" + urlAction + "] error reponse", response);
                // on analyse le status
                var status = response.status;
                var error;
                switch (status){
                    case 401:
                        //unauthorized
                        error = 2;
                        break;
                    case 403:
                        // forbidden
                        error = 3;
                        break;
                    case 404:
                        // not found
                        error = 6;
                        break;
                    case 0:
                        // erreur locale
                        error = 4;
                        break;
                    default:
                        //autre chose
                        error = 5;
                }
                //on rend la réponse
                task.resolve({err: error, messages: [response.statusText]});
            }
        }

        // instance du service [dao]
        return {
            getData: getData
        }
    }]);



//contrôleur
angular.module("rdvmedecins").controller('rdvMedecinsCtrl', ['$scope', 'utils', 'dao', '$translate', 'config',
    function($scope, utils, dao, $translate, config){
        //initialisation modèle
        // message d'attente
        // modèle
        $scope.waiting = {text: config.msgWaiting, visible: false, cancel: cancel, time: undefined};
        $scope.waitingTimeText = config.waitingTimeText;
        $scope.server = {url: undefined, login: undefined, password: undefined};
        $scope.medecins = {title: config.listMedecins, show: false, model: {}};
        $scope.errors = {show: false, model: {}};
        $scope.urlServerLabel = config.urlServerLabel;
        $scope.loginLabel = config.loginLabel;
        $scope.passwordLabel = config.passwordLabel;

        //tâche asynchrone
        var task;

        //exécution action
        $scope.execute = function () {
            // on met à jour l'UI
            $scope.waiting.visible = true;
            $scope.medecins.show = false;
            $scope.errors.show = false;
            // attente simulée
            task = utils.waitForSomeTime($scope.waiting.time);
            var promise = task.promise;
            //attente
            promise = promise.then(function () {
                //on demande la liste des médecins
                task = dao.getData($scope.server.url, $scope.server.login, $scope.server.password, config.urlSvrMedecins);
                return task.promise;
            });
            // on analyse le résultat de l'appel précédent
            promise.then(function (result) {
                //result={err: 0, data: [med1, med2, ...]}
                //result={err: n, messages: [msg1, msg2, ...]}
                if (result.err == 0){
                    //on met les données acquises dans le modèle
                    $scope.medecins.data = result.data;
                    //on met à jour l'UI
                    $scope.medecins.show = true;
                    $scope.waiting.visible = false;
                } else {
                    //il y a eu des erreurs pour obtenir la liste des médecins
                    $scope.errors = {title: config.getMedecinsErrors, messages: utils.getErrors(result), show: true, model: {}};
                    //on met à jour l'UI
                    $scope.waiting.visible = false;
                }
            });
        };

        //annulation attente
        function cancel(){
            //on termine la tâche
            task.reject();
            //on met à jour l'UI
            $scope.waiting.visible = false;
            $scope.medecins.show = false;
            $scope.errors.show = false;
        }
    }]);

