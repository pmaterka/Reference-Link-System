import React, {Component} from "react";
import TreeService from "../services/TreeService";

class TreeComponent extends Component{

    constructor(props) {
        super(props);

        this.state ={
            survey: []
        }
        this.addSurvey = this.addSurvey.bind(this);
        this.editSurvey = this.editSurvey.bind(this);
        this.deleteSurvey = this.deleteSurvey.bind(this);
    }

    deleteSurvey(id){
        TreeService.deleteSurvey(id).then(res => {
            this.setState({survey: this.state.survey.filter(survey => survey.id !== id)});
        });
    }
    viewSurvey(id){
        this.props.history.push(`/viewDetails/${id}`);
    }
    componentDidMount() {
        TreeService.getSurveys().then((res) => {
            this.setState({
                survey: res.data
                }

            );
        })
    }
    editSurvey(id){
        this.props.history.push(`/add/${id}`)

    }

    addSurvey (){
        this.props.history.push('/add/add');

    }

    render() {
        return(
            <div>
                <div className="row">
                    <button className="btn btn-outline-primary" onClick={this.addSurvey}>
                        Dodaj ankiete
                    </button>

                </div>

                <div className="row">

                    <div className="tree">
                        <ul>
                            <li>
                                <a href="#">Ankieta</a>
                                <div className="a row">
                                    <table className="table table-striped table-bordered">
                                        <tbody>
                                        {
                                            this.state.survey.map(
                                                survey =>
                                                    <tr key={ survey.id }>
                                                        <td>{ survey.surveyQuestions }</td>
                                                    </tr>
                                            )
                                        }

                                        </tbody>
                                    </table>
                                </div>

                                <ul>
                                    <li>
                                        <a href="#">Pytanie1</a>
                                        <ul>
                                            <li>
                                                <a href="#">Odpowiedz</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">Pytanie2</a>
                                        <ul>
                                            <li><a href="#">Odpowiedz1</a></li>
                                            <li>
                                                <a href="#">Odpowiedz2</a>
                                                <ul>
                                                    <li>
                                                        <a href="#">Rozwiazanie problemu1</a>
                                                    </li>
                                                    <li>
                                                        <a href="#">Rozwiazanie problemu 2</a>
                                                    </li>
                                                    <li>
                                                       <a href="#">Rozwiazanie problemu 3</a>
                                                    </li>
                                                </ul>
                                            </li>
                                            <li><a href="#">Odpowiedz3</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }

}
export default TreeComponent