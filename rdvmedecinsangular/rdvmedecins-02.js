/**
 * Created by GuillaumeD on 21/04/2016.
 */

//module Angular
angular.module("rdvmedecins", ['ui.bootstrap', 'ngLocale', 'pascalprecht.translate']);

//configuration initiale
angular.module("rdvmedecins").config(['$translateProvider', function ($translateProvider) {
    //messages français
    $translateProvider.translations("fr", {
        'msg_header': 'Cabinet Médical<br/>Les Médecins Associés',
        'msg_langues': 'Langues',
        'msg_agenda': 'Agenda de {{titre}} {{prenom}} {{nom}}<br/>le {{jour}}',
        'msg_calendrier': 'Calendrier',
        'msg_jour': 'Jour sélectionné : ',
        'msg_meteo' : "Aujourd'hui, il va pleuvoir...",
        'msg_waiting' : "Opération en cours. Patientez...",
        'msg_cancel' : "Annuler"
    });
    //messages anglais
    $translateProvider.translations("en", {
        'msg_header': 'The Associated Doctors',
        'msg_langues': 'Languages',
        'msg_agenda': "{{titre}} {{prenom}} {{nom}}'s Diary <br/> on {{jour}}",
        'msg_calendrier': 'Calendar',
        'msg_jour': 'Selected day: ',
        'msg_meteo': 'Today, it will be raining...',
        'msg_waiting' : "Operation running. Please waiting...",
        'msg_cancel' : "Cancel"
    });
    //langue par défaut
    $translateProvider.preferredLanguage("fr");
}]);

//service
angular.module("rdvmedecins").factory('config', function () {
    return {
        //messages à internationaliser
        msgWaitingInit: "msg_waiting_init",
        msgWaiting: "msg_waiting",
        loadingError: "loading_error",
        canceledOperation: 'canceled_operation',
        getMedecinsErrors: 'get_medecins_errors',
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

//contrôleur
angular.module("rdvmedecins").controller('rdvMedecinsCtrl', ['$scope', '$locale', '$translate', '$filter', 'config',
    function($scope, $locale, $translate, $filter, config){
        //initialisation modèle
        //datepicker options
        $scope.options = {
            minDate: new Date(),
            showWeeks: true
        };
        //on met par défaut le calendrier en français
        angular.copy(config.locales['fr'], $locale);
        //date d'aujourd'hui
        $scope.jour= new Date();
        //message d'attente
        $scope.waiting = {'text': config.msgWaiting, 'visible': false, 'cancel': cancel};


        //un texte à traduire
        $scope.msg = {'text': 'msg_agenda', 'model': {'titre': 'Mme', 'prenom': 'Laure', 'nom': 'PELISSIER', 'jour': $filter('date')($scope.jour, 'fullDate')}};
        //un autre texte à traduire
        $scope.msg2 = $filter('translate')('msg_meteo');

        //gestionnaire d'événements
        //changement de langue
        $scope.setLang = function (lang) {
            //on change la locale
            angular.copy(config.locales[lang], $locale);
            //on met à jour le jour affiché pour forcer le calendrier à changer de locale
            $scope.jour = new Date($scope.jour.getTime());
            //on ferme la liste déroulante
            $scope.isopen = false;
            //on change la langue de traduction
            $translate.use(lang);
            //on met à jour msg2
            $scope.msg2 = $filter('translate')('msg_meteo');
            //et le jour de msg
            $scope.msg.model.jour = $filter('date')($scope.jour, 'fullDate');
        };

        //changement de jour dans le calendrier
        $scope.calendarClick = function () {
            //modification du jour affiché
            $scope.msg.model.jour = $filter('date')($scope.jour, 'fullDate');
        }

        //annulation attente
        function cancel() {
            //on cache le msg d'attente
            $scope.waiting.visible = false;
        }
    }]);
