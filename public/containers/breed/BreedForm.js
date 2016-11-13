import React, { Component } from 'react'
import { reduxForm } from 'redux-form'
import { createBreed } from '../../actions/ActionsBreed'
import  breedValidate from './BreedValidation'

class BreedForm extends Component {

  render() {
    let { fields : { id, name }, handleSubmit } = this.props
    return (
      <form onSubmit={ handleSubmit(this.props.createBreed) }>
        <h3>Raça: </h3>
        <div className="form-group">
          <label>Id</label>
          <input type="text" className="form-control" {...id} />
        </div>
        <div className="form-group">
          <label>Descrição</label>
          <input type="text" className="form-control" {...name} />
          <div>
            {name.touched ? name.error : ''}
          </div>
        </div>
        <button type="submit" >
          Gravar
        </button>
      </form>
    )
  }
}



export default reduxForm({
  form : 'BreedForm',
  fields : ['id', 'name'],
  validate : breedValidate
}, null, { createBreed })(BreedForm)
