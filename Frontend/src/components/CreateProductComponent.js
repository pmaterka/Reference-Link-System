import React, {Component} from "react";
import ProductService from "../services/ProductService";


class CreateProductComponent extends Component{

    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            name: '',
            price: ' ',
            available: ' '
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changePriceHandler =this.changePriceHandler.bind(this);
        this.changeAvailableHandler = this.changeAvailableHandler.bind(this);
        this.saveOrUpdateProduct = this.saveOrUpdateProduct.bind(this);
    }


    componentDidMount(){


        if(this.state.id === 'add'){
            return
        }else{
            ProductService.getProductById(this.state.id).then( (res) =>{
                let product = res.data;
                this.setState({name: product.name,
                    price: product.price,
                    available: product.available.toString,
                });
            });
        }
    }
    saveOrUpdateProduct = (e) => {
        e.preventDefault();
        let product = {name: this.state.name, price: this.state.price, available: this.state.available};
        console.log('product => ' + JSON.stringify(product));


        if(this.state.id === 'add'){
            ProductService.createProduct(product).then(res =>{
                this.props.history.push('/');
            });
        }else{
            ProductService.updateProduct(product, this.state.id).then( res => {
                this.props.history.push('/');
            });
        }
    }

    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changePriceHandler= (event) => {
        this.setState({price: event.target.value});
    }

    changeAvailableHandler= (event) => {
        this.setState({available: event.target.value});
    }

    cancel(){
        this.props.history.push('/');
    }

    getTitle(){
        if(this.state.id === 'add'){
            return <h3 className="text-center">Add Product</h3>
        }else{
            return <h3 className="text-center">Update Product</h3>
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
                                        <label> Product Name: </label>
                                        <input placeholder="Product Name" name="name" className="form-control"
                                               value={this.state.name} onChange={this.changeNameHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Price: </label>
                                        <input placeholder="Product Price" price="price" className="form-control"
                                               value={this.state.price} onChange={this.changePriceHandler}/>
                                    </div>
                                    <div className = "form-group">
                                        <label> Available</label>
                                        <input placeholder="Available" available="available" className="form-control"
                                               value={this.state.available} onChange={this.changeAvailableHandler}/>
                                    </div>


                                    <button className="btn btn-success" onClick={this.saveOrUpdateProduct}>Save</button>
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

export default CreateProductComponent