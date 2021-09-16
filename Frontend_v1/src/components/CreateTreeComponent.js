import React, {Component} from "react";
import TreeService from "../services/TreeService";


class CreateTreeComponent extends Component{

    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            surveyQuestions: []
        }
        this.changeSurveyQuestionsHandler = this.changeSurveyQuestionsHandler.bind(this);
        this.saveOrUpdateSurvey = this.saveOrUpdateSurvey.bind(this);
    }


    componentDidMount(){


        if(this.state.id === 'add'){
            return
        }else{
            TreeService.getSurveyById(this.state.id).then( (res) =>{
                let survey = res.data;
                this.setState({
                    surveyQuestions: survey.surveyQuestions,
                });
            });
        }
    }
    saveOrUpdateSurvey = (e) => {
        e.preventDefault();
        let survey = {surveyQuestions: this.state.surveyQuestions};
        console.log('product => ' + JSON.stringify(survey));


        if(this.state.id === 'add'){
            TreeService.createSurvey(survey).then(res =>{
                this.props.history.push('/');
            });
        }else{
            TreeService.updateSurvey(survey, this.state.id).then( res => {
                this.props.history.push('/');
            });
        }
    }

    changeSurveyQuestionsHandler= (event) => {
        this.setState({name: event.target.value});
    }


    cancel(){
        this.props.history.push('/');
    }

    getTitle(){
        if(this.state.id === 'add'){
            return <h3 className="text-center">Add Survey</h3>
        }else{
            return <h3 className="text-center">Update Survey</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                <div className = "container">
                    <div className = "row">
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            <div className = "card-body">
                                <form>
                                    <div className = "form-group">
                                        <label> Survey Questions: </label>
                                        <input placeholder="Survey Questions" name="name" className="form-control"
                                               value={this.state.surveyQuestions} onChange={this.changeSurveyQuestionsHandler}/>
                                    </div>



                                    <button className="btn btn-success" onClick={this.saveOrUpdateSurvey}>Save</button>
                                    <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default CreateTreeComponent