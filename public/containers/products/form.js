import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'
import InputElement from 'react-input-mask'

class ProductForm extends Component {

  render() {
    let { fields : { id, description, price, stockAmount } } = this.props
    return (
      <form onSubmit={ this.props.handleSubmit(this.props.action) }>
        <p className="control has-icon has-icon-right">
          <input type="hidden" className="input" { ...id } readOnly/>
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Descrição</label>
          <input type="text" className={`input ${description.error && description.touched ? `is-danger` : ``} `} {...description} maxLength='60'/>
          {description.error && description.touched && <i className="fa fa-warning"></i>}
          {description.error && description.touched && <span className="help is-danger">{ description.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Preço:</label>
          <input type="number" className={`input ${price.error && price.touched ? `is-danger` : ``} `} {...price} step="0.01"/>
          {price.error && price.touched && <i className="fa fa-warning"></i>}
          {price.error && price.touched && <span className="help is-danger">{ price.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Quantidade Atual de Estoque</label>
          <input type="number" className={`input ${stockAmount.error && stockAmount.touched ? `is-danger` : ``} `} {...stockAmount} maxLength='60'/>
          {stockAmount.error && stockAmount.touched && <i className="fa fa-warning"></i>}
          {stockAmount.error && stockAmount.touched && <span className="help is-danger">{ stockAmount.error }</span>}
        </p>
        <p className="control">
          <button type="submit"  className="button is-primary">Gravar</button>
        </p>
      </form>
    )
  }
}

function mapStateToProps(state) {
  return {
    initialValues : state.productsState.actual
  }
}

export default reduxForm({
  form : 'ProductForm',
  fields : ['id', 'description', 'price', 'stockAmount'],
  validate : (values) => {
    let error = {}

    if(!values.description)
      error.description = 'Informe a descrição do Produto!'
    if(!values.price)
      error.price = 'Informe o preço do Produto!'
    if(!values.stockAmount)
      error.stockAmount = 'Informe o preço do Produto!'

    return error;
  }

}, mapStateToProps, { changeFieldValue })(ProductForm)
