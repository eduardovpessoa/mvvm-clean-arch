package br.com.eduardovpessoa.ui.leadingdeathcauses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.eduardovpessoa.R
import br.com.eduardovpessoa.data.remote.dto.DesignTemplateItem
import java.util.Locale

class LeadingDeathCausesAdapter(
    private val dataSet: DesignTemplateItem,
) : RecyclerView.Adapter<LeadingDeathCausesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtLeadingCause: TextView
        val txtSexAndYear: TextView
        val txtDeathsAndRates: TextView

        init {
            txtLeadingCause = view.findViewById(R.id.txt_leading_cause)
            txtSexAndYear = view.findViewById(R.id.txt_sex_and_year)
            txtDeathsAndRates = view.findViewById(R.id.txt_deaths_and_rates)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.row_leading_death_causes, viewGroup, false)
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.txtLeadingCause.text = dataSet[position].leadingCause
        viewHolder.txtSexAndYear.text =
            "Year: ${dataSet[position].year} - Sex: ${dataSet[position].sex}"
        viewHolder.txtDeathsAndRates.text = if (dataSet[position].deathRate.isNullOrEmpty()) {
            "Deaths: ${dataSet[position].deaths} (Mortality % N/A)"
        } else {
            "Deaths: ${dataSet[position].deaths} " +
                "(Mortality ${
                    "%,.2f".format(
                        Locale.ENGLISH,
                        dataSet[position].deathRate?.toFloat()
                    )
                }%)"
        }
    }

    override fun getItemCount() = dataSet.size
}