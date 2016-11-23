import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'


class BreedForm extends Component {

  render() { 
    return (
      <form onSubmit={ this.props.handleSubmit(this.props.action) }>
        <h3>Raça: </h3>
        <div className="form-group">
          <label>Id</label>
          <input type="text" className="form-control" { ...this.props.fields.id } />
        </div>
        <div className="form-group">
          <label>Descrição</label>
          <input type="text" className="form-control" {...this.props.fields.name} />
          <div>
            {this.props.fields.name.touched ? this.props.fields.name.error : ''}
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
