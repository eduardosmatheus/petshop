import React, { Component } from 'react'
import Select, { Creatable } from 'react-select'

import { createBreed } from '../../actions/ActionsBreed'

import { reduxForm, change as changeFieldValue } from 'redux-form'

class AnimalForm extends Component {
  render() {
    let { fields : { id, name, birth, obs, breed, especie, customer }, breeds, especies, customers } = this.props
    return (
      <form onSubmit={ this.props.handleSubmit(this.props.action) }>
        <p className="control has-icon has-icon-right">
          <input type="hidden" className="input" { ...id } readOnly/>
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Nome Pet:</label>
          <input type="text" className={`input ${name.error && name.touched ? `is-danger` : ``} `} {...name} maxLength='60'/>
          {name.error && name.touched && <i className="fa fa-warning"></i>}
          {name.error && name.touched && <span className="help is-danger">{ name.error }</span>}
        </p>
        <div className="control">
          <label className="label">Raça:</label>
          <Select
            {...breed}
            options={breeds.map((breed) => {  return {value: breed.id, label: breed.name} } )}
            onBlur={() => breed.onBlur(breed.value)}/>
        </div>
        <div className="control">
          <label className="label">Especie:</label>
          <Select
            {...especie}
            options={especies.map((especie) => {  return {value: especie.id, label: especie.description} } )}
            onBlur={() => especie.onBlur(especie.value)}/>
        </div>
        <div className="control">
          <label className="label">Proprietário do Pet:</label>
          <Select
            {...customer}
            options={customers.map((customer) => {  return {value: customer.id, label: ('' + customer.name + '/' + customer.cpf + '')} } )}
            onBlur={() => customer.onBlur(customer.value)}/>
        </div>
        <p className="control has-icon has-icon-right">
          <label className="label">Nascimento do Pet:</label>
          <input type="date" className={`input ${birth.error && birth.touched ? `is-danger` : ``} `} {...birth}/>
          {birth.error && birth.touched && <i className="fa fa-warning"></i>}
          {birth.error && birth.touched && <span className="help is-danger">{ birth.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Obs:</label>
          <textarea className={`textarea ${obs.error && obs.touched ? `is-danger` : ``} `} {...obs} maxLength='250'/>
          {obs.error && obs.touched && <i className="fa fa-warning"></i>}
          {obs.error && obs.touched && <span className="help is-danger">{ obs.error }</span>}
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
    breeds : state.breedState.all,
    especies : state.especieState.all,
    customers : state.customerState.all,
    initialValues : state.animalsState.actual
  }
}

export default reduxForm({
  form : 'AnimalForm',
  fields : ['id', 'name', 'birth', 'obs', 'breed', 'especie', 'customer'],
  validate : (values) => {
    let error = {}

    if(!values.name)
      error.name = 'Informe a descrição da Pet!'

    return error;
  }

}, mapStateToProps, { changeFieldValue, createBreed })(AnimalForm)
