import React, { Component } from 'react'
import { reduxForm, change as changeFieldValue } from 'redux-form'


class EmployeerForm extends Component {

  render() {
    let { fields : { id, name, cpf, phone, email, entryTime, lunchTime, entryTimeAfterLunch, homeTime } } = this.props
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
        <p className="control has-icon has-icon-right">
          <label className="label">Horário inicio do espediente</label>
          <input type="time" className={`input ${entryTime.error && entryTime.touched ? `is-danger` : ``} `} {...entryTime} maxLength='60'/>
          {entryTime.error && entryTime.touched && <i className="fa fa-warning"></i>}
          {entryTime.error && entryTime.touched && <span className="help is-danger">{ entryTime.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Horário saída para almoço</label>
          <input type="time" className={`input ${lunchTime.error && lunchTime.touched ? `is-danger` : ``} `} {...lunchTime} maxLength='60'/>
          {lunchTime.error && lunchTime.touched && <i className="fa fa-warning"></i>}
          {lunchTime.error && lunchTime.touched && <span className="help is-danger">{ lunchTime.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Horário volta do almoço</label>
          <input type="time" className={`input ${entryTimeAfterLunch.error && entryTimeAfterLunch.touched ? `is-danger` : ``} `} {...entryTimeAfterLunch} maxLength='60'/>
          {entryTimeAfterLunch.error && entryTimeAfterLunch.touched && <i className="fa fa-warning"></i>}
          {entryTimeAfterLunch.error && entryTimeAfterLunch.touched && <span className="help is-danger">{ entryTimeAfterLunch.error }</span>}
        </p>
        <p className="control has-icon has-icon-right">
          <label className="label">Horário fim expediente</label>
          <input type="time" className={`input ${entryTimeAfterLunch.error && homeTime.touched ? `is-danger` : ``} `} {...homeTime} maxLength='60'/>
          {homeTime.error && homeTime.touched && <i className="fa fa-warning"></i>}
          {homeTime.error && homeTime.touched && <span className="help is-danger">{ homeTime.error }</span>}
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
    initialValues : state.employeersState.actual
  }
}

export default reduxForm({
  form : 'EmployeerForm',
  fields : ['id', 'name', 'cpf', 'phone', 'email',  'entryTime', 'lunchTime', 'entryTimeAfterLunch', 'homeTime'],
  validate : (values) => {
    let error = {}

    if(!values.name)
      error.name = 'Informe o nome do empregado!'

    if(!values.cpf)
      error.cpf = 'Informe o cpf do empregado!'

    if(!values.phone)
      error.phone = 'Informe o telefone do empregado!'

    if(!values.email)
      error.email = 'Informe o e-mail do empregado!'

    return error;
  }

}, mapStateToProps, { changeFieldValue })(EmployeerForm)
