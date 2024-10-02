package com.example.raditgames

import com.example.raditgames.R
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.raditgames.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private var TotalRate = 0
    private var Hero = 0
    private var Kelas = 0
    private var Item = 0
    private var HeroRate = 0
    private var KelasRate = 0
    private var ItemRate = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        Glide.with(this).load(R.drawable.warrior).into(binding!!.ivhero)
        binding!!.rghero.setOnCheckedChangeListener { radioGroup, i ->
            if (binding!!.rbhr1.isChecked()) {
                setHero(1)
                Hero = 1
                Kelas = 0
                binding!!.rgkelas.clearCheck()
            } else if (binding!!.rbhr2.isChecked()) {
                setHero(2)
                Hero = 2
                Kelas = 0
                binding!!.rgkelas.clearCheck()
            } else if (binding!!.rbhr3.isChecked()) {
                setHero(3)
                Hero = 3
                Kelas = 0
                binding!!.rgkelas.clearCheck()
            }
        }
        binding!!.rgkelas.setOnCheckedChangeListener { radioGroup, i ->
            if (binding!!.rbkls1.isChecked()) {
                setKelas(1)
                Kelas = 1
            } else if (binding!!.rbkls2.isChecked()) {
                setKelas(2)
                Kelas = 2
            }
        }
        binding!!.cbattack.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked()) {
                Item = 1
            }
        }
        binding!!.cbdefendbox.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked()) {
                Item = 2
            }
        }
        binding!!.cbaspd.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked()) {
                Item = 3
            }
        }
        binding!!.cbhp.setOnCheckedChangeListener { compoundButton, b ->
            if (compoundButton.isChecked()) {
                Item = 4
            }
        }
        binding!!.btnproses.setOnClickListener { v ->
            if (binding!!.etnmchar.getText().toString()
                    .isEmpty() || Hero == 0 || Kelas == 0 || Item == 0
            ) {
                Toast.makeText(this, "Mohon lengkapi pilihan disamping!", Toast.LENGTH_SHORT).show()
            } else {
                if (Hero == 1) {
                    HeroRate = 12000
                    if (Kelas == 1) {
                        KelasRate = 5000
                    } else if (Kelas == 2) {
                        KelasRate = 7000
                    }
                } else if (Hero == 2) {
                    HeroRate = 13000
                    if (Kelas == 1) {
                        KelasRate = 4000
                    } else if (Kelas == 2) {
                        KelasRate = 6000
                    }
                } else if (Hero == 3) {
                    HeroRate = 10000
                    if (Kelas == 1) {
                        KelasRate = 3500
                    } else if (Kelas == 2) {
                        KelasRate = 5000
                    }
                }
                if (Item == 1) {
                    ItemRate = 10000
                } else if (Item == 2) {
                    ItemRate = 8000
                } else if (Item == 3) {
                    ItemRate = 5000
                } else if (Item == 4) {
                    ItemRate = 12000
                }
                TotalRate = HeroRate + KelasRate + ItemRate
                binding!!.tvNmChar.setText(binding!!.etnmchar.getText().toString())
                binding!!.tvHerorate.setText(HeroRate.toString())
                binding!!.tvKelasrate.text = KelasRate.toString()
                binding!!.tvItemrate.text = ItemRate.toString()
                binding!!.tvtr.setText(TotalRate.toString())
                binding!!.tvTotarate.text = TotalRate.toString()
            }
        }
    }

    private fun setHero(job: Int) {
        if (job == 1) {
            binding?.rbkls1?.setText("Champion")
            binding?.rbkls2?.setText("Paladin")
            Glide.with(this).load(R.drawable.warrior).into(binding?.ivhero!!)
        } else if (job == 2) {
            binding?.rbkls1?.setText("Hunter")
            binding?.rbkls2?.setText("Sniper")
            Glide.with(this).load(R.drawable.archer).into(binding?.ivhero!!)
        } else if (job == 3) {
            binding?.rbkls1?.setText("Wizard")
            binding?.rbkls2?.setText("Sorcerer")
            Glide.with(this).load(R.drawable.mage).into(binding?.ivhero!!)
        }
    }

    private fun setKelas(jobClass: Int) {
        if (Hero == 1) {
            if (jobClass == 1) {
                Glide.with(this).load(R.drawable.warrrior_champion).into(binding?.ivhero!!)
            } else if (jobClass == 2) {
                Glide.with(this).load(R.drawable.warrior_paladin).into(binding?.ivhero!!)
            }
        } else if (Hero == 2) {
            if (jobClass == 1) {
                Glide.with(this).load(R.drawable.archer_hunter).into(binding?.ivhero!!)
            } else if (jobClass == 2) {
                Glide.with(this).load(R.drawable.archer_sniper).into(binding?.ivhero!!)
            }
        } else if (Hero == 3) {
            if (jobClass == 1) {
                Glide.with(this).load(R.drawable.mage_wizard).into(binding?.ivhero!!)
            } else if (jobClass == 2) {
                Glide.with(this).load(R.drawable.mage_sorcerer).into(binding?.ivhero!!)
            }
        }
    }
}
