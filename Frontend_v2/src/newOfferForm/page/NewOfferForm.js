import useCustomForm from "../../hooks/use-form";
import {useHistory} from 'react-router-dom';

const FORM_FIELDS = [
    {
        fieldName: 'name',
        label: 'nazwa usługi',
        type: 'text',
        minLength: 2,
        maxLength: 24,
        required: true
    },
    {
        fieldName: 'description',
        label: 'opis usługi',
        type: 'text',
        multiline: true,
        minRows: 4,
        maxRows: 4,
        minLength: 8,
        maxLength: 128,
        required: true
    },
    {
        fieldName: 'offerCost',
        label: 'cena',
        type: 'number',
        min: 1,
        required: true
    },
    {
        fieldName: 'offerCategory',
        label: 'kategoria',
        type: 'select',
        options: ['wspieranie', 'organizacja', 'zarabianie', 'kierowanie', 'promowanie', 'komunikowanie', 'uświadamianie', 'naprawa', 'hodowla', 'poszukiwanie', 'analiza i badania', 'pomaganie innym', 'budowanie zrozumienia', 'dawanie otuchy innym', 'łączenie zasobów i możliwości', 'przedsiębiorczość', 'zarządzanie zasobami', 'przywództwo', 'uważność', 'synergia w działaniu', 'uczciwość', 'generowanie', 'ochrona','instruktaż', 'nabywanie kompotencji', 'umiejętność pracy pod presją czasu', 'dbałość o dobrą atmosferę', 'rozwiązywanie konfliktów', 'motywowanie pracowników', 'logiczne myślenie', 'motywacja samorozwoju', 'obsługa technologii', 'porada'],
        required: true
    },
    {
        fieldName: 'offerorGroup',
        label: 'grupa oferująca',
        type: 'select',
        options: ['psycholodzy i terapeuci', 'społeczność', 'właściciele domów', 'właściciele mieszkań', 'najemcy domów i mieszkań', 'urzędy i instytucje', 'przedsiębiorcy', 'seniorzy', 'młodzież', 'rodzice', 'rolnicy', 'pracownicy', 'studenci', 'wykładowcy i naukowcy', 'rektorzy', 'dyrektorzy szkół', 'organizacje pozarządowe', 'osoby bezrobotne', 'osoby niepełnosprawne', 'inna grupa'],
        required: true
    },
    {
        fieldName: 'offerArea',
        label: 'obszar',
        type: 'select',
        options: ['świadomość życia', 'natura wokół mnie', 'firma i organizacja', 'usługi i wykonastwo', 'relacje z rodziną', 'relacje ze znajommi', 'ścieżka artysty', 'narzędzia i systemy pracy', 'komunikacja online', 'komputer i telefon', 'internet i narzędzia', 'komunikacja miejska', 'postrzeganie innych', 'szkołai i rozwój', 'świadoma uprawa roślin', 'zwierzęta wokół nas', 'świadome i zdrowe żywienie', 'dbałość o zdrowie', 'pasja i aktywności'],
        required: true
    },
    {
        fieldName: 'optionNeedOffer',
        label: 'opcja',
        type: 'select',
        options: ['potrzebuję', 'oferuję', 'potrzebuję i oferuję'],
        required: true
    },
    {
        fieldName: 'offerReason',
        label: 'dlaczego to robię?',
        type: 'select',
        options: ['spokój', 'cierpliwość', 'kochanie', 'uwolnienie', 'jednoczenie', 'zaufanie', 'wiedza', 'cieszenie się', 'wdzięczność', 'zaopiekowanie', 'kreowanie', 'prawdziwość', 'sprawczość', 'komunikowanie', 'odwdzięczanie', 'zadośćuczynienie', 'dawanie z serca'],
        required: true
    },
    {
        fieldName: 'isUrgent',
        label: 'pilność',
        type: 'select',
        options: ['pilne', 'niepilne'],
        required: true
    },
];

const NewOffer = props => {
    const history = useHistory();

    const {form, data} = useCustomForm({inputs: FORM_FIELDS, title: 'Stwórz ofertę', buttonText: 'DODAJ OFERTĘ', url: 'offer', method: 'POST', redirect: '/products/new', auth: true});

    if(data) history.push(`/offers/${data.id}/add-product`);

    return form;
}

export default NewOffer;