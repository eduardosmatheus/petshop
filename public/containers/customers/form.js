import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'


class CustomerForm extends Component {

  render() {
    let { fields : { id, name, cpf, phone, email } } = this.props
    return (
      <form onSubmit={ this.props.handleSubmit(this.props.action) }>
        <p className="control has-icon has-icon-right">
          <input type="hidden" className="input" { ...id } readOnly/>
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Nome</label>
          <input type="text" className={`input ${name.error && name.touched ? `is-danger` : ``} `} {...name} maxLength='60'/>
          {name.error && name.touched && <i className="fa fa-warning"></i>}
          {name.error && name.touched && <span className="help is-danger">{ name.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">CPF</label>
          <input type="text" className={`input ${cpf.error && cpf.touched ? `is-danger` : ``} `} {...cpf} maxLength='60'/>
          {cpf.error && cpf.touched && <i className="fa fa-warning"></i>}
          {cpf.error && cpf.touched && <span className="help is-danger">{ cpf.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Telefone</label>
          <input type="text" className={`input ${phone.error && phone.touched ? `is-danger` : ``} `} {...phone} maxLength='60'/>
          {phone.error && phone.touched && <i className="fa fa-warning"></i>}
          {phone.error && phone.touched && <span className="help is-danger">{ phone.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">E-mail</label>
          <input type="email" className={`input ${email.error && email.touched ? `is-danger` : ``} `} {...email} maxLength='60'/>
          {email.error && email.touched && <i className="fa fa-warning"></i>}
          {email.error && email.touched && <span className="help is-danger">{ email.error }</span>}
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
    initialValues : state.customerState.actual
  }
}

export default reduxForm({
  form : 'CustomerForm',
  fields : ['id', 'name', 'cpf', 'phone', 'email'],
  validate : (values) => {
    let error = {}

    if(!values.name)
      error.name = 'Informe o nome do cliente!'

    if(!values.cpf)
      error.cpf = 'Informe o cpf do cliente!'

    if(!values.phone)
      error.phone = 'Informe o telefone do cliente!'

    if(!values.email)
      error.email = 'Informe o e-mail do cliente!'

    return error;
  }

}, mapStateToProps, { changeFieldValue })(CustomerForm)
