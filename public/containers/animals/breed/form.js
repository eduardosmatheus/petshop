import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'


class BreedForm extends Component {

  render() {
    let { fields : { id, name } } = this.props
    return (
      <form onSubmit={ this.props.handleSubmit(this.props.action) }>
        <p className="control has-icon has-icon-right">
          <label className="label">Id</label>
          <input type="text" className="input" { ...id } readOnly/>
          <label className="label">Descrição</label>
        </p>
        <p className="control has-icon has-icon-right">
          <input type="text" className={`input ${name.error && name.touched ? `is-danger` : ``} `} {...name} maxLength='60'/>
          {name.error && name.touched && <i className="fa fa-warning"></i>}
          {name.error && name.touched && <span className="help is-danger">{ name.error }</span>}
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
    initialValues : state.breedState.actual
  }
}

export default reduxForm({
  form : 'BreedForm',
  fields : ['id', 'name'],
  validate : (values) => {
    let error = {}

    if(!values.name)
      error.name = 'Informe a descrição da Raça!'

    return error;
  }

}, mapStateToProps, { changeFieldValue })(BreedForm)
