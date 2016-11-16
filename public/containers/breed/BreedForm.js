import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'
import { createBreed, getBreed } from '../../actions/ActionsBreed'
import  breedValidate from './BreedValidation'


class BreedForm extends Component {

  componentWillMount() {
    let { id } = this.props.params
    if(id)
      this.props.getBreed(id);

  }

  render() {
    let { fields : { id, name }, handleSubmit, breeds, values } = this.props
    let { actual } = breeds

    return (
      <form onSubmit={ handleSubmit(this.props.createBreed) }>
        <h3>Raça: </h3>
        <div className="form-group">
          <label>Id</label>
          <input type="text" className="form-control" { ...id } />
        </div>
        <div className="form-group">
          <label>Descrição</label>
          <input type="text" className="form-control" {...name} />
          <div>
            {name.touched ? name.error : ''}
          </div>
        </div>
        <button type="submit" className="btn btn-primary">
          Gravar
        </button>
      </form>
    )
  }
}

function mapStateToProps(state) {
  return {
    breeds : state.breedState,
    initialValues : state.breedState.actual
  }
}

export default reduxForm({
  form : 'BreedForm',
  fields : ['id', 'name'],
  validate : breedValidate
}, mapStateToProps, { createBreed, getBreed, changeFieldValue })(BreedForm)
