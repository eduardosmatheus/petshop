import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'


class EspecieForm extends Component {

  render() {
    let { fields : { id, description } } = this.props
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
        <p className="control">
          <button type="submit"  className="button is-primary">Gravar</button>
        </p>
      </form>
    )
  }
}

function mapStateToProps(state) {
  return {
    initialValues : state.especieState.actual
  }
}

export default reduxForm({
  form : 'EspecieForm',
  fields : ['id', 'description'],
  validate : (values) => {
    let error = {}

    if(!values.description)
      error.description = 'Informe a descrição da Especie!'

    return error;
  }

}, mapStateToProps, { changeFieldValue })(EspecieForm)
