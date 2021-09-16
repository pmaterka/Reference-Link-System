import axios from 'axios';

const SURVEY_API_BASE_URL ="http://localhost:8080/survey";

class TreeService {

    getSurveys (){

        return axios.get(SURVEY_API_BASE_URL);
    }

    createSurvey(survey){
        return axios.post(SURVEY_API_BASE_URL, survey);
    }
    getSurveyById (surveyId){
        return axios.get(SURVEY_API_BASE_URL +'/'+ surveyId);
    }
    updateSurvey(survey, surveyId){
        return axios.put(SURVEY_API_BASE_URL + '/'+ surveyId, survey)
    }
    deleteSurvey(surveyId){
        return axios.delete(SURVEY_API_BASE_URL + '/' + surveyId);
    }
}

export default new TreeService()